package com.cindata.housekeeper.web.controller;

import com.cindata.housekeeper.core.common.tools.*;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.PayParameter;
import com.cindata.housekeeper.web.bean.WxUserInfo;
import com.cindata.housekeeper.web.service.UserInfoService;
import com.cindata.housekeeper.wx.common.tools.WXPayUtil;
import com.cindata.housekeeper.wx.model.WxPaymentLog;
import com.cindata.housekeeper.wx.model.WxReport;
import com.cindata.housekeeper.wx.service.WxPaymentLogService;
import com.cindata.housekeeper.wx.service.WxReportService;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.cindata.housekeeper.core.common.tools.OpenapiPoster.LOGIN_URL;
import static com.cindata.housekeeper.core.common.tools.PayWxConfigUtil.TRADE_TYPE_GZH;

/**
 * 通用服务
 * @author yangss
 * @date   2018.01.30 10:57
 */
@Controller
@RequestMapping(value = "/wx")
public class WeixinServer {
	//我们的Token
    private static final String token = "tokensh";
    //公众号北京提供
   // private static final String appid = "wxe6de6dcf79f06bb3";
   // private static final String AppSecret = "abc60cf0e4378055a588f1c8a52bda0f";
   //公众号房产管家
    private static final String appid = "wxb921c981d390122e";
    private static final String AppSecret = "8b22d14bfc8d45560abc7bda73f8f237";
    //公众号测试环境
    //private static final String appid = "wxd374ad6cdfe5a3bc";
    //private static final String AppSecret = "0a0fe32af97d5c556bdab155da43b564";
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private WxPaymentLogService wxPaymentLogService;

    @Autowired
    private WxReportService wxReportService;
    private static final Logger logger = LoggerFactory.getLogger(WeixinServer.class);

    /**
	 * 微信验证
	 */
	@RequestMapping(value="/portal", produces="text/html;charset=UTF-8")
	@ResponseBody
	public void portal(HttpServletRequest request, HttpServletResponse response){

		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		System.out.println("signature:" + signature);
		System.out.println("timestamp:" + timestamp);
		System.out.println("nonce:" + nonce);
		System.out.println("echostr:" + echostr);
		if(checkSignature(signature,timestamp,nonce)){
			PrintWriter pw = null;
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pw.append(echostr);
			pw.flush();
		}
	}
	public static Boolean checkSignature(String signature,String timestamp,String nonce){
		String[] strs=new String[] {token,timestamp,nonce};
		Arrays.sort(strs);
		StringBuffer content=new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			content.append(strs[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;
		try {
   			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
            tmpStr = SHA1Util.encode(content.toString());
			/*byte[] digest = md.digest(content.toString().getBytes());
            if (digest != null) {
                tmpStr = new BASE64Encoder().encode(digest);
            }*/
			//tmpStr = Convert.ToBase64String(StrRes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return signature!=null?signature.toUpperCase().equals(tmpStr.toUpperCase()):false;
	}
    /**
     * 获取accessToken
     */
    public static String getAccessToken(){
        String gurl = "https://api.weixin.qq.com/cgi-bin/token";
        String accessToken = null;
        try {

            String accessTokenJson = HttpRequest.sendGet(gurl,"grant_type=client_credential&appid="+appid+"&secret="+AppSecret);
            JSONObject object1 = JSONObject.fromObject(accessTokenJson);
            accessToken = object1.getString("access_token");
            System.out.println("accessToken:" + accessToken);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }


        return accessToken;
    }
    /**
     * 微信配置
     */
    @RequestMapping(value="/getWxConfig", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getWxConfig(HttpServletRequest request, HttpServletResponse response){
        String weburl = request.getParameter("url");
        Long timestamp = System.currentTimeMillis()/1000;
        int noncestr = new Random().nextInt();
        String gurl = "https://api.weixin.qq.com/cgi-bin/token";
        //获取jsapi_ticket
        String jsapi_ticket = null;
        JSONResult<Map> res = new JSONResult<Map>();
        try {
            // AccessTokenUtil accessTokenUtil = new AccessTokenUtil();
            String accessTokenJson = HttpRequest.sendGet(gurl,"grant_type=client_credential&appid="+appid+"&secret="+AppSecret);
            JSONObject object1 = JSONObject.fromObject(accessTokenJson);
            String accessToken = object1.getString("access_token");
            System.out.println("accessToken:" + accessToken);

            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
            String responseText = HttpRequest.sendGet(url,"access_token=" + accessToken + "&type=jsapi");
            jsapi_ticket = null;
            JSONObject object = JSONObject.fromObject(responseText);
            if (object.containsKey("ticket")) {
                jsapi_ticket = object.getString("ticket");
                //使用request对象的getSession()获取session，如果session不存在则创建一个
                HttpSession session = request.getSession();
               session.setAttribute("jsapi_ticket",jsapi_ticket);
                session.setMaxInactiveInterval(12*60);
            }
            res.setMessage("ok");
            res.setStatusCode(1);
            res.setSuccess(true);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }

        //生成signature

        String signature =createSignature(noncestr,timestamp,weburl,jsapi_ticket,"SHA1");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jsapi_ticket", jsapi_ticket);
        map.put("appId", appid);
        map.put("signature", signature.toLowerCase());
        map.put("timestamp", timestamp.toString());
        map.put("noncestr", String.valueOf(noncestr));
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;

        res.setData(map);
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }
    public static String createSignature(int noncestr,long timestamp, String weburl, String jsapi_ticket,String type){
        List<String> nameList = new ArrayList<String>();
        nameList.add("noncestr");
        nameList.add("timestamp");
        nameList.add("url");
        nameList.add("jsapi_ticket");
        Map<String, Object> valueMap = new HashMap<String, Object>();
        valueMap.put("noncestr", noncestr);
        valueMap.put("timestamp", timestamp);
        valueMap.put("url", weburl);
        valueMap.put("jsapi_ticket", jsapi_ticket);
        Collections.sort(nameList);
        String origin = "";
        for (int i = 0; i < nameList.size(); i++) {
            origin += nameList.get(i) + "=" + valueMap.get(nameList.get(i)).toString() + "&";
        }
        origin = origin.substring(0, origin.length() - 1);
        String signature = "";
        if("MD5".equals(type)){
            signature = MD5Utils.MD5Encode(origin.toString(), "utf-8").toUpperCase();
        }else if("SHA1".equals(type)){
            signature = SHA1Util.encode(origin);
        }


        return signature;
    }
    /**
     * 获取微信语音流
     */
    @RequestMapping(value="/getWxYy", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getWxYy(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Long timestamp = System.currentTimeMillis()/1000;
        int noncestr = new Random().nextInt();

        //获取jsapi_ticket
        String jsapi_ticket = null;
        JSONResult res = new JSONResult();
        try {
            String gurl = "https://api.weixin.qq.com/cgi-bin/token";
            String accessTokenJson = HttpRequest.sendGet(gurl,"grant_type=client_credential&appid="+appid+"&secret="+AppSecret);
            JSONObject object1 = JSONObject.fromObject(accessTokenJson);
            String accessToken = object1.getString("access_token");
            System.out.println("accessToken:" + accessToken);
            // AccessTokenUtil accessTokenUtil = new AccessTokenUtil();
            gurl = "http://file.api.weixin.qq.com/cgi-bin/media/get";
            String url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="+accessToken+"&media_id="+id;
            try {
                InputStream is = null;
                URL urlGet = new URL(url);
                HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
                http.setRequestMethod("GET"); // 必须是get方式请求
                http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                http.setDoOutput(true);
                http.setDoInput(true);

                System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
                System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
                http.connect();
                // 获取文件转化为byte流
                is = http.getInputStream();
                //存储到硬盘，原本音频格式为amr

                    byte[] buffer = new byte[1024];
			/*File logosavedir = new File(path1);// path1为存放的路径
			if (!logosavedir.exists()) {// 如果不存在文件夹，则自动生成
				logosavedir.mkdirs();
			}*/
                    FileOutputStream out = new FileOutputStream("d://111.arm");
                    int bytesum = 0;
                    int byteread = 0;
                    while ((byteread = is.read(buffer)) != -1) {
                        bytesum += byteread;
                        out.write(buffer, 0, byteread); // 文件写操作
                        out.flush();
                    }
                    out.close();

               // String sourcePath=FileTool.writeFile(is, "_"+userid+".amr","voice");
                //arm Convert Mp3
               // changeToMp3(sourcePath+"_"+userid+".amr",sourcePath+"_"+userid+".mp3");

            } catch (Exception e) {
                e.printStackTrace();
            }

            String str = HttpRequest.sendGet(gurl,"access_token="+accessToken+"&media_id="+id);
            //JSONObject object1 = JSONObject.fromObject(accessTokenJson);
            //String accessToken = object1.getString("access_token");
            System.out.println("str:" + str);
            res.setData(str);
            res.setMessage("ok");
            res.setStatusCode(1);
            res.setSuccess(true);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }



        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }

    /**
     * 微信登录获取用户信息
     */

    public static WxUserInfo getWxUserInfo(HttpServletRequest request, String code){
        System.out.println("ip:" + PayWxCommonUtil.getClientIp(request));
        //String code = request.getParameter("code");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        String sessionCode = (String)session.getAttribute("code");

        WxUserInfo bean = null;
        String gurl = "https://api.weixin.qq.com/sns/oauth2/access_token";
        JSONResult<WxUserInfo> res = new JSONResult<WxUserInfo>();
        try {
            // AccessTokenUtil accessTokenUtil = new AccessTokenUtil();
            System.out.println("code:" + code);
            //刷新token
            //String strUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
            //String str = HttpRequest.sendGet(strUrl,"appid="+appid+"&grant_type=refresh_token&refresh_token=REFRESH_TOKEN"+code);
            String accessTokenJson = "";
            if(sessionCode != null && sessionCode.equals(code)){
                accessTokenJson = (String)session.getAttribute("accessTokenJson");
            }else{


                accessTokenJson = HttpRequest.sendGet(gurl,"grant_type=authorization_code&appid="+appid+"&secret="+AppSecret+"&code="+code);
                System.out.println("accessTokenJson:" + accessTokenJson);
                //将数据存储到session中
                session.setAttribute("code", code);
                session.setAttribute("accessTokenJson", accessTokenJson);

            }
            JSONObject object1 = JSONObject.fromObject(accessTokenJson);
            if(!object1.containsKey("access_token")){
                return null;
            }
            String accessToken = object1.getString("access_token");
            String openId = object1.getString("openid");
            System.out.println("accessToken:" + accessToken);


            String url = "https://api.weixin.qq.com/sns/userinfo";
            String responseText = HttpRequest.sendGet(url,"access_token=" + accessToken +"&openid="+openId+ "&lang=zh_CN");
            //responseText = new String(responseText.getBytes("ISO-8859-1"), "GBK");
            System.out.println("responseText:" + responseText);
            /*String responseText="{    \"openid\":\" OPENID\"," +
                    "\" nickname\": NICKNAME," +
                    "\"sex\":\"1\"," +
                    "\"province\":\"PROVINCE\"," +
                    "\"city\":\"CITY\"," +
                    "\"country\":\"COUNTRY\"," +
                    "\"headimgurl\":    \"http://thirdwx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46\"," +
                    "\"privilege\":[ \"PRIVILEGE1\" ,\"PRIVILEGE2\"     ]," +
                    "\"unionid\": \"o6_bmasdasdsad6_2sgVt7hMZOPfL\"" +
                    "}";*/
           // responseText = responseText.replaceAll(" ","");
            bean = (WxUserInfo) CtrlerUtil.json2bean(responseText, new TypeToken<WxUserInfo>(){}.getType());


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bean;
    }

    /**
     * 检验授权凭证（access_token）是否有效
     */
    public static Boolean auth(String accessToken,String openid){

        String gurl = "https://api.weixin.qq.com/sns/auth";

        Boolean bol = false;
        try {
            // AccessTokenUtil accessTokenUtil = new AccessTokenUtil();
            String json = HttpRequest.sendGet(gurl,"access_token="+accessToken+"&openid="+openid);
            System.out.println("json:" + json);
            JSONObject object1 = JSONObject.fromObject(json);
            String errcode = object1.getString("errcode");
           if("0".equals(errcode)){
               bol = true;
           }else{
               bol = false;
           }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            bol = false;
        }

        return bol;
    }

    /**
     * 发送消息
     */
    @RequestMapping(value="/send", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String send(HttpServletRequest request, HttpServletResponse response){

        JSONResult<WxUserInfo> res = new JSONResult<WxUserInfo>();
        try {
            String accessToken = request.getParameter("accessToken");
            sendMsg(accessToken);
            res.setMessage("ok");
            res.setStatusCode(1);
            res.setSuccess(true);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }

        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }
    /**
     * 发送模板消息
     */
    public String sendMsg(String accessToken){

        String gurl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken;

        JSONResult<WxUserInfo> res = new JSONResult<WxUserInfo>();
        try {
            String data = " {" +
                    "           \"touser\":\"ontqf0am-SIzCsD_8B4DtCTlW4zM\"," +
                    "           \"template_id\":\"FzyKEIyFMRpzYXM42Pq4YNZJKCfsyd2N6F58BSeqAtE\"," +
                    // "           \"url\":\"http://c04db44a.ngrok.io/housekeeper/page_home/login.html\",  " +
                   /* "           \"miniprogram\":{" +
                    "             \"appid\":\""+appid+"\"," +
                    "             \"pagepath\":\"index?foo=bar\"" +
                    "           },          " +*/
                    "           \"data\":{" +
                    "                   \"first\": {" +
                    "                       \"value\":\"恭喜你购买成功！\"," +
                    "                       \"color\":\"#173177\"" +
                    "                   }," +
                    "                   \"keyword1\":{" +
                    "                       \"value\":\"巧克力\"," +
                    "                       \"color\":\"#173177\"" +
                    "                   }," +
                    "                   \"keyword2\": {" +
                    "                       \"value\":\"39.8元\"," +
                    "                       \"color\":\"#173177\"" +
                    "                   }," +
                    "                   \"keyword3\": {" +
                    "                       \"value\":\"2014年9月22日\"," +
                    "                       \"color\":\"#173177\"" +
                    "                   }," +
                    "                   \"keyword4\": {" +
                    "                       \"value\":\"2014年9月22日\"," +
                    "                       \"color\":\"#173177\"" +
                    "                   }," +
                    "                   \"keyword5\": {" +
                    "                       \"value\":\"2014年9月22日\"," +
                    "                       \"color\":\"#173177\"" +
                    "                   }," +
                    "                   \"remark\":{" +
                    "                       \"value\":\"欢迎再次购买！\"," +
                    "                       \"color\":\"#173177\"" +
                    "                   }" +
                    "           }" +
                    "       }";
            String json = HttpRequest.sendPost(gurl,data,"UTF-8");
            System.out.println("json:" + json);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }


        return "";
    }


    /**
     * 发送模板消息
     */
    public static String sendMsg(String accessToken,String openId,String templateId,String jsonData){

        String gurl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken;

        JSONResult<WxUserInfo> res = new JSONResult<WxUserInfo>();
        try {
            String data = " {" +
                    "           \"touser\":\""+openId+"\"," +
                    "           \"template_id\":\""+templateId+"\"," +
                    "           \"url\":\""+LOGIN_URL+"\",  " +
                   /* "           \"miniprogram\":{" +
                    "             \"appid\":\""+appid+"\"," +
                    "             \"pagepath\":\"index?foo=bar\"" +
                    "           },          " +*/
                    "           \"data\":"+jsonData+""+
                    "       }";
            String json = HttpRequest.sendPost(gurl,data,"UTF-8");
            System.out.println("json:" + json);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }


        return "";
    }

    /**
     * 微信公众号支付
     */
    @RequestMapping(value="/wxPay", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String wxPay(HttpServletRequest request, HttpServletResponse response){
        JSONResult res = new JSONResult();
        try {

            String openid = request.getParameter("openid");
            String userId = request.getParameter("userId");
            BigDecimal communityId = StringUtil.parseBigDecimal(request.getParameter("communityId"),null);
            String communityName = request.getParameter("communityName");
            BigDecimal type = StringUtil.parseBigDecimal(request.getParameter("type"),null);
            BigDecimal period = StringUtil.parseBigDecimal(request.getParameter("period"),null);
            String title = request.getParameter("title");
            BigDecimal money = StringUtil.parseBigDecimal(request.getParameter("money"),null);
            PayParameter payParameter = new PayParameter();
            //删除所有未支付订单
            //只按userId 检索，没按 下单超时逻辑
            wxReportService.deleteReportByUserId(userId);
            //报告表生成数据（订单）
            WxReport wxReport = new WxReport();
            wxReport.setTitle(title);
            wxReport.setType(type);
            wxReport.setPeriod(period);
            wxReport.setIsRead(new BigDecimal(0));
            wxReport.setIsExpired(new BigDecimal(0));
            wxReport.setStatus(new BigDecimal(0));
            wxReport.setIsPay(new BigDecimal(0));
            wxReport.setMoney(money);
            wxReport.setUserId(userId);
            wxReport.setCommunityId(communityId);
            wxReport.setCommunityName(communityName);
            wxReportService.addReport(wxReport);
            String reportId =wxReport.getId();
            payParameter.setType(TRADE_TYPE_GZH);
            payParameter.setOrderName("订阅报告");
            payParameter.setOrderId(reportId);
            payParameter.setMoney(money);
            //测试价格 1分钱
            //payParameter.setMoney(new BigDecimal(1));
            payParameter.setSceneInfo("房产管家测试");
            //获取ip
           // String ip = PayWxCommonUtil.getClientIp(request);
            String ip = PayWxCommonUtil.getClientIp(request);
            if(ip.indexOf("/")>0){
                ip = ip.substring(0,ip.indexOf("/"));
            }
            logger.error(PayWxCommonUtil.getClientIp(request));
            logger.error(ip);
            logger.error(request.getRemoteAddr());
            logger.error(request.getHeader("X-Real-IP"));
            payParameter.setIp(ip);

            // 商业号
            String mch_id = PayWxConfigUtil.getMchid();
            // key
            String key = PayWxConfigUtil.getKey();
            //appId
            String appId = PayWxConfigUtil.getAppid();
            String currTime = PayWxCommonUtil.getCurrTime();
            String strTime = currTime.substring(8, currTime.length());
            String strRandom = PayWxCommonUtil.buildRandom(4) + "";
            //随机字符串
            String nonce_str = strTime + strRandom;
            //设置入参
            SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
            packageParams.put("mch_id", mch_id);
            packageParams.put("appid", appId);
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("trade_type", payParameter.getType());

            //商品信息
            packageParams.put("body", payParameter.getOrderName());
            packageParams.put("out_trade_no", payParameter.getOrderId().toString());
            packageParams.put("total_fee", payParameter.getMoney().toString());
            packageParams.put("spbill_create_ip", payParameter.getIp());
            packageParams.put("notify_url", PayWxConfigUtil.NOTIFY_URL);
            packageParams.put("scene_info", payParameter.getSceneInfo());
            packageParams.put("openid", openid);

            String sign = PayWxCommonUtil.createSign("UTF-8", packageParams,key);
            packageParams.put("sign", sign);

            String requestXML = PayWxCommonUtil.getRequestXml(packageParams);
            String resXml =  HttpRequest.sendPost(PayWxConfigUtil.PAY_API, requestXML,"utf-8");

            System.out.println(resXml);
            String prepay_id = "调用失败";
            if(resXml.indexOf("![CDATA[OK]]")>-1){
                String str = resXml.split("prepay_id")[1];
                int i = str.indexOf("CDATA[");
                int j = str.indexOf("]",i+6);
                prepay_id = str.substring(i+6,j);
                System.out.println(prepay_id);
                //getWxConfig
                //使用request对象的getSession()获取session，如果session不存在则创建一个
               // HttpSession session = request.getSession();
               // String jsapi_ticket = (String)session.getAttribute("jsapi_ticket");
                //if(StringUtil.isNotNullOrEmpty(jsapi_ticket)) {
                    //生成signature
                   /* String weburl = request.getParameter("url");
                    Long timestamp = System.currentTimeMillis() / 1000;
                    int noncestr = new Random().nextInt();
                    String signature = createSignature(noncestr, timestamp, weburl, jsapi_ticket,"MD5");*/
                    Map map = new HashMap();
                    map.put("appId", appId);
                    map.put("nonceStr", nonce_str+"");

                    map.put("package", "prepay_id=" + prepay_id);
                    map.put("timeStamp", Long.toString(System.currentTimeMillis() / 1000));
                    map.put("signType", "MD5");

                    map.put("paySign", WXPayUtil.generateSignature(map,key));
                    map.put("reportId",reportId);
                    res.setData(map);
                    res.setMessage("ok");
                    res.setStatusCode(1);
                    res.setSuccess(true);
               /* }else{
                    res.setMessage("session 失效,请重新登陆");
                    res.setStatusCode(99);
                    res.setSuccess(false);
                }*/
            }else{
                res.setMessage("no ok");
                res.setStatusCode(2);
                res.setSuccess(false);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }

        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }

    @RequestMapping(value = "/weixinNotify", produces="text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public void weixinNotify(HttpServletRequest request, HttpServletResponse response) throws Exception  {
        //		System.out.println("--------进入回调方法-----------");
//		Long service_start_time = System.currentTimeMillis();
        //读取参数
        InputStream inputStream ;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();
        String s ;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while ((s = in.readLine()) != null){
            sb.append(s);
        }
        in.close();
        inputStream.close();
//	    System.out.println("--------入参-----------"+sb);
        //解析xml成map
        Map<String, String> m = new HashMap<String, String>();
        m = XMLUtil.doXMLParse(sb.toString());

        //过滤空 设置 TreeMap
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
        Iterator it = m.keySet().iterator();
        while (it.hasNext()) {
            String parameter = (String) it.next();
            String parameterValue = m.get(parameter);

            String v = "";
            if(null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }
        //记录接口调用日志
        String spbill_create_ip = PayWxCommonUtil.getClientIp(request);
//	    System.out.println("--------请求IP是-----------"+spbill_create_ip);
        WxPaymentLog payment_log_notify = new WxPaymentLog();
//        payment_log_notify.setGoodsId(new BigDecimal(payParameter.getProductId()));
        payment_log_notify.setStatus(new BigDecimal(0));
        payment_log_notify.setGetData(sb.toString());
        payment_log_notify.setIp(spbill_create_ip);
        payment_log_notify.setPayMethod("wx");
//        payment_log_notify.setChannel("wx");

        // 账号信息
        String key = PayWxConfigUtil.getKey(); // key
        String out_trade_no = (String)packageParams.get("out_trade_no");
        //logger.info(packageParams);
        payment_log_notify.setOrderId(out_trade_no);
        //更新 报表支付状态
        wxReportService.updateReporPay(out_trade_no);
        System.out.println("--------key-----------"+packageParams.get("key"));
        //判断签名是否正确
        Long check_start_time = System.currentTimeMillis();
        if(PayWxCommonUtil.isTenpaySign("UTF-8", packageParams,key)) {
            Long check_use_time = System.currentTimeMillis() - check_start_time;
            System.out.println("校验签名总用时------->"+check_use_time);
            //------------------------------
            //处理业务开始
            //------------------------------
//	    	System.out.println("--------验证签名成功-----------");
            String resXml = "";
            System.out.println("-----------status------->"+packageParams.get("result_code"));
            if("SUCCESS".equals((String)packageParams.get("result_code"))){
                //支付成功 将订阅数据插入表中
                payment_log_notify.setRetcode((String)packageParams.get("result_code"));
                payment_log_notify.setRetmsg("支付成功");
                // 这里是支付成功
                //////////执行自己的业务逻辑////////////////
//	        	String app_id = (String)packageParams.get("appid");
//                String mch_id = (String)packageParams.get("mch_id");
//                String openid = (String)packageParams.get("openid");
//                String is_subscribe = (String)packageParams.get("is_subscribe");//是否关注公众号
//
                //付款金额【以分为单位】
                String total_fee = (String)packageParams.get("total_fee");
//                //微信生成的交易订单号
//                String transaction_id = (String)packageParams.get("transaction_id");//微信支付订单号
//                //支付完成时间
//                String time_end=(String)packageParams.get("time_end");

                //正常处理相关业务逻辑
                //通知子系统支付成功
//                Long child_back_start_time = System.currentTimeMillis();
                //修改订单状态：交易成功
                //System.out.println("-----------orderid------->"+out_trade_no);
               /* OrderInfo oi = new OrderInfo();
                oi.setStatus(new BigDecimal(1));
                oi.setOrderId(StringUtil.parseBigDecimal(out_trade_no,null));
                int i = orderInfoService.updateOrderInfo(oi);*/
                //System.out.println("-----------orderid------->"+out_trade_no);
                //boolean sign = orderInfoService.postNotify(out_trade_no,"wx",total_fee);
                //System.out.println("-----------statrus------->1");
//                Long child_back_use_time = System.currentTimeMillis() - child_back_start_time;
//    	        System.out.println("调用子系统通知接口总用时------->"+child_back_use_time);
                //if(sign){
                    //通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.
                    resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
               /* }else{
                    payment_log_notify.setRetcode(PayWxConfigUtil.WX_RETCODE_ERROR_SUBSYSTEM);
                    payment_log_notify.setRetmsg("支付失败");
                }*/
            } else {
                System.out.println("支付失败,错误信息：" + packageParams.get("err_code")+ "-----订单号：：："+out_trade_no+"*******支付失败时间：：：："
                        +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                //修改订单状态：交易失败
               /* OrderInfo oi = new OrderInfo();
                oi.setStatus(new BigDecimal(2));
                oi.setOrderId(StringUtil.parseBigDecimal(out_trade_no,null));
                int i = orderInfoService.updateOrderInfo(oi);*/
//	            String err_code = (String)packageParams.get("err_code");
                payment_log_notify.setRetcode(PayWxConfigUtil.WX_RETCODE_ERROR_WXCALLBACK);
                payment_log_notify.setRetmsg("支付失败");
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";

            }
//	        System.out.println("--------resXml-----------"+resXml);
            payment_log_notify.setPutData(resXml);
            //------------------------------
            //处理业务完毕
            //------------------------------
            System.out.println("-----------statrus------->2");
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();

        } else{
            payment_log_notify.setRetcode(PayWxConfigUtil.WX_RETCODE_ERROR_SIGN);
            payment_log_notify.setRetmsg("通知签名验证失败");
            System.out.println("通知签名验证失败---时间::::"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        System.out.println("-----------statrus------->3");
        wxPaymentLogService.addWxPaymentLog(payment_log_notify);
        System.out.println("-----------statrus------->4");
//	    Long service_use_time = System.currentTimeMillis() - service_start_time;
//        System.out.println("回调service层总用时------->"+service_use_time);
    }
}

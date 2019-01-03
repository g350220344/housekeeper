package com.cindata.housekeeper.core.common.tools;

import com.cindata.housekeeper.wx.dao.SmsLogMapper;
import com.cindata.housekeeper.wx.model.SmsLog;
import com.cindata.housekeeper.wx.model.SmsLogExample;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class SMSUtil {

	   //查账户信息的http地址
    private static String URI_GET_USER_INFO =
        "https://sms.yunpian.com/v2/user/get.json";

    //智能匹配模板发送接口的http地址
    private static String URI_SEND_SMS =
        "https://sms.yunpian.com/v2/sms/single_send.json";

    //模板发送接口的http地址
    private static String URI_TPL_SEND_SMS =
        "https://sms.yunpian.com/v2/sms/tpl_single_send.json";

    //发送语音验证码接口的http地址
    private static String URI_SEND_VOICE =
        "https://voice.yunpian.com/v2/voice/send.json";

    //绑定主叫、被叫关系的接口http地址
    private static String URI_SEND_BIND =
        "https://call.yunpian.com/v2/call/bind.json";

    //解绑主叫、被叫关系的接口http地址
    private static String URI_SEND_UNBIND =
        "https://call.yunpian.com/v2/call/unbind.json";

    //编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";
    
    //key
    private static String apikey = "0ec03b2171ae7785ed472a763572e232";
   
    //文本短信模板id
    private static String tpl_id = "2075738";
    
    

    public static void main(String[] args) throws IOException,
        URISyntaxException {

            //修改为您的apikey.apikey可在官网（http://www.yunpian.com)登录后获取
            String apikey = "b5796709233fda0989a336f9782234c1";

            //修改为您要发送的手机号
            String mobile = "13936457091";

            /**************** 查账户信息调用示例 *****************/
            //System.out.println(getUserInfo(apikey));

            /**************** 使用智能匹配模板接口发短信(推荐) *****************/
            //设置您要发送的内容(内容必须和某个模板匹配。以下例子匹配的是系统提供的1号模板）
            String text = "【房产管家】 房价提醒：您的房产 [哈尔滨市 紫金城] 09月房价涨了0.00万,涨幅0.0%，详情请至微信公众号";
        //发短信调用示例
             System.out.println(sendSms( text, mobile));

            /**************** 使用指定模板接口发短信(不推荐，建议使用智能匹配模板接口) ******/
            //设置模板ID，如使用1号模板:【#company#】您的验证码是#code#
            long tpl_id = 1;
            //设置对应的模板变量值

            String tpl_value = URLEncoder.encode("#code#", ENCODING) + "=" +
                URLEncoder.encode("1234", ENCODING) + "&" + URLEncoder.encode(
                    "#company#", ENCODING) + "=" + URLEncoder.encode("云片网",
                    ENCODING);
            //模板发送的调用示例
            System.out.println(tpl_value);

            //System.out.println(tplSendSms(apikey, new SmsLogMapper() ,tpl_id, tpl_value, mobile));

            /**************** 使用接口发语音验证码 *****************/
            String code = "8765";
            //System.out.println(sendVoice(mobile ,code));

            /**************** 使用接口绑定主被叫号码 *****************/
            String from = "+86130xxxxxxxx";
            String to = "+86131xxxxxxxx";
            Integer duration = 30 * 60; // 绑定30分钟
            //System.out.println(JavaSmsApi.bindCall(apikey, from ,to , duration));

            /**************** 使用接口解绑主被叫号码 *****************/
            //System.out.println(JavaSmsApi.unbindCall(apikey, from, to));
        }


    
    
    /**
     * 取账户信息
     *
     * @return json格式字符串
     * @throws java.io.IOException
     */

    public static String getUserInfo(String apikey) throws IOException,
        URISyntaxException {
            Map < String, String > params = new HashMap < String, String > ();
            params.put("apikey", apikey);
            return post(URI_GET_USER_INFO, params);
        }

    /**
     * 智能匹配模板接口发短信
     *
     * @param apikey apikey
     * @param text   　短信内容
     * @param mobile 　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */

    public static String sendSms( String text,
        String mobile) throws IOException {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("apikey", apikey);
        params.put("text", text);
        params.put("mobile", mobile);
        return post(URI_SEND_SMS, params);
    }

    /**
     * 通过模板发送短信(不推荐)
     *
     * @param apikey    apikey
     * @param tpl_id    　模板id
     * @param tpl_value 　模板变量值
     * @param mobile    　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */

    public static String tplSendSms(
        String mobile,SmsLogMapper logger, String ip, String spId,String tempId) throws IOException {
        Map < String, String > params = new HashMap < String, String > ();
        String tpl_value = URLEncoder.encode("#code#", ENCODING) + "=" +
                //URLEncoder.encode(code, ENCODING);
        params.put("apikey", apikey);
        //之前是写死的模板id，现在换成参数了。
        //params.put("tpl_id", String.valueOf(tpl_id));
        params.put("tpl_id", tempId);
        params.put("tpl_value", tpl_value);
        params.put("mobile", mobile);
        String res = post(URI_TPL_SEND_SMS, params);
		JSONObject reqJo = null;
        SmsLog log = new SmsLog();
        try {
			reqJo = new JSONObject();
			reqJo.put("params", params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(res != null){
			log.setResponseBody(res);
		}
		if(reqJo != null){
			log.setContent(reqJo.toString());
			log.setRequestBody(reqJo.toString());
		}
		
		log.setMobile(mobile);
		log.setIp(ip);
		//log.setSpId(spId);
		log.setSendTime(new Timestamp(System.currentTimeMillis()));
		//log.setState(res + "");
		logger.insertSelective(log);
        return res;
    }
    /**
     * 通过模板发送短信(不推荐)
     *
     * @param apikey    apikey
     * @param tpl_id    　模板id
     * @param tpl_value 　模板变量值
     * @param mobile    　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */

    public static String tplSendSms(
            String mobile,String code,SmsLogMapper logger, String ip, String spId,String tempId) throws IOException {
        Map < String, String > params = new HashMap < String, String > ();
        String tpl_value = URLEncoder.encode("#code#", ENCODING) + "=" +
                URLEncoder.encode(code, ENCODING);
        params.put("apikey", apikey);
        //之前是写死的模板id，现在换成参数了。
        //params.put("tpl_id", String.valueOf(tpl_id));
        params.put("tpl_id", tempId);
        params.put("tpl_value", tpl_value);
        params.put("mobile", mobile);
        String res = post(URI_TPL_SEND_SMS, params);
        JSONObject reqJo = null;
        SmsLog log = new SmsLog();
        try {
            reqJo = new JSONObject();
            reqJo.put("params", params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(res != null){
            log.setResponseBody(res);
        }
        if(reqJo != null){
            log.setContent(reqJo.toString());
            log.setRequestBody(reqJo.toString());
        }

        log.setMobile(mobile);
        log.setIp(ip);
        log.setSpId(spId);
        log.setSendTime(new Timestamp(System.currentTimeMillis()));
        //log.setState(res + "");
        logger.insertSelective(log);
        return res;
    }
    /**
     * 通过接口发送语音验证码
     * @param apikey apikey
     * @param mobile 接收的手机号
     * @param code   验证码
     * @return
     */

    public static String sendVoice(String mobile, String code,SmsLogMapper logger, String ip) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("apikey", apikey);
        params.put("mobile", mobile);
        params.put("code", code);
        String returnlog = post(URI_SEND_VOICE, params);
        SmsLog log = new SmsLog();
        JSONObject reqJo = null;
        reqJo = new JSONObject();
		reqJo.put("params", params);
    	if(returnlog != null){
			log.setResponseBody(returnlog);
		}
		if(reqJo != null){
			log.setContent(reqJo.toString());
			log.setRequestBody(reqJo.toString());
		}
    	log.setMobile(mobile);
		log.setIp(ip);
		log.setSendTime(new Timestamp(System.currentTimeMillis()));
		logger.insertSelective(log);
        return returnlog;
    }

    /**
     * 通过接口绑定主被叫号码
     * @param apikey apikey
     * @param from 主叫
     * @param to   被叫
     * @param duration 有效时长，单位：秒
     * @return
     */

    public static String bindCall(String apikey, String from, String to,
        Integer duration) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("apikey", apikey);
        params.put("from", from);
        params.put("to", to);
        params.put("duration", String.valueOf(duration));
        return post(URI_SEND_BIND, params);
    }

    /**
     * 通过接口解绑绑定主被叫号码
     * @param apikey apikey
     * @param from 主叫
     * @param to   被叫
     * @return
     */
    public static String unbindCall(String apikey, String from, String to) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("apikey", apikey);
        params.put("from", from);
        params.put("to", to);
        return post(URI_SEND_UNBIND, params);
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */

    public static String post(String url, Map < String, String > paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List < NameValuePair > paramList = new ArrayList <
                    NameValuePair > ();
                for (Map.Entry < String, String > param: paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(),
                        param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList,
                    ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, ENCODING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
}

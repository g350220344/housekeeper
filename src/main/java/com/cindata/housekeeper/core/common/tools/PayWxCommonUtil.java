package com.cindata.housekeeper.core.common.tools;

import javax.servlet.http.HttpServletRequest;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description  微信支付工具类  
 * @author lqs
 * @2018-03-06 
 */
public class PayWxCommonUtil {  
      
    /** 
     * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。 
     * @return boolean 
     */  
    public static boolean isTenpaySign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {  
        StringBuffer sb = new StringBuffer();  
        Set es = packageParams.entrySet();  
        Iterator it = es.iterator();  
        while(it.hasNext()) {  
            Map.Entry entry = (Map.Entry)it.next();  
            String k = (String)entry.getKey();  
            String v = (String)entry.getValue();  
            if(!"sign".equals(k) && null != v && !"".equals(v)) {  
                sb.append(k + "=" + v + "&");  
            }  
        }  
          
        sb.append("key=" + API_KEY);  
          
        //算出摘要  
        String mysign = MD5Utils.MD5Encode(sb.toString(), characterEncoding).toLowerCase();  
        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();  
          
        System.out.println(tenpaySign + "    " + mysign);
        return tenpaySign.equals(mysign);  
    }  
  
    /** 
     * @author 
     * @date 2016-4-22 
     * @Description：sign签名 
     * @param characterEncoding 
     *            编码格式 
     * @param parameters 
     *            请求参数 
     * @return 
     */  
    public static String createSign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {  
        StringBuffer sb = new StringBuffer();  
        Set es = packageParams.entrySet();  
        Iterator it = es.iterator();  
        while (it.hasNext()) {  
            Map.Entry entry = (Map.Entry) it.next();  
            String k = (String) entry.getKey();  
            String v = (String) entry.getValue();  
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {  
                sb.append(k + "=" + v + "&");  
            }  
        }  
        sb.append("key=" + API_KEY);  
        String sign = MD5Utils.MD5Encode(sb.toString(), characterEncoding).toUpperCase();  
        return sign;  
    }  
  
    /** 
     * @author 
     * @date 2016-4-22 
     * @Description：将请求参数转换为xml格式的string 
     * @param parameters 
     *            请求参数 
     * @return 
     */  
    public static String getRequestXml(SortedMap<Object, Object> parameters) {  
        StringBuffer sb = new StringBuffer();  
        sb.append("<xml>");  
        Set es = parameters.entrySet();  
        Iterator it = es.iterator();  
        while (it.hasNext()) {  
            Map.Entry entry = (Map.Entry) it.next();  
            String k = (String) entry.getKey();  
            String v = (String) entry.getValue();  
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {  
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");  
            } else {  
                sb.append("<" + k + ">" + v + "</" + k + ">");  
            }  
        }  
        sb.append("</xml>");  
        return sb.toString();  
    }  
  
    /** 
     * 取出一个指定长度大小的随机正整数. 
     *  
     * @param length 
     *            int 设定所取出随机数的长度。length小于11 
     * @return int 返回生成的随机数。 
     */  
    public static int buildRandom(int length) {  
        int num = 1;  
        double random = Math.random();  
        if (random < 0.1) {  
            random = random + 0.1;  
        }  
        for (int i = 0; i < length; i++) {  
            num = num * 10;  
        }  
        return (int) ((random * num));  
    }  
  
    /** 
     * 获取当前时间 yyyyMMddHHmmss 
     *  
     * @return String 
     */  
    public static String getCurrTime() {  
        Date now = new Date();  
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
        String s = outFormat.format(now);  
        return s;  
    }  
  
    /**
	 * 获得客户端IP
	 * @param 
	 * @return 
	 */
	public static String getClientIp(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();  
		String forwarded = request.getHeader("X-Forwarded-For");  
		String realIp = request.getHeader("X-Real-IP");  
		String ip = null;  
		if (realIp == null) {  
		    if (forwarded == null) {  
		        ip = remoteAddr;  
		    } else {  
		        ip = remoteAddr + "/" + forwarded.split(",")[0];  
		    }  
		} else {  
		    if (realIp.equals(forwarded)) {  
		        ip = realIp;  
		    } else {  
		        if(forwarded != null){  
		            forwarded = forwarded.split(",")[0];  
		        }  
		        ip = realIp + "/" + forwarded;  
		    }  
		}
		return ip;
	}
    /**
     * 获得客户端IP
     * @param
     * @return
     */
    public static String getClientIp(HttpServletRequest request,String type) {
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress().toString();
            System.out.println("hostAddress:" + hostAddress);
            String hostName = InetAddress.getLocalHost().getHostName();
            System.out.println("hostName:" + hostName);
            if (hostName.length() > 0) {
                InetAddress[] addrs = InetAddress.getAllByName(hostName);
                if (addrs.length > 0) {
                    for (int i = 0; i < addrs.length; i++) {
                        InetAddress address = addrs[i];
                        System.out.println("**********************");
                        System.out.println(address.getHostAddress());
                        if (address instanceof Inet6Address) {
                            System.out.println("true6");
                        } else if(address instanceof Inet4Address){
                            System.out.println("true4");
                        } else {
                            System.out.println("unknown");
                        }
                        System.out.println("**********************");
                    }
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }
	/** 
     * 获取本机IP地址 
     * @author  
     * @return 
     */  
    public static String localIp(){  
        String ip = null;  
        Enumeration allNetInterfaces;  
        try {  
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();              
            while (allNetInterfaces.hasMoreElements()) {  
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();  
                List<InterfaceAddress> InterfaceAddress = netInterface.getInterfaceAddresses();  
                for (InterfaceAddress add : InterfaceAddress) {  
                    InetAddress Ip = add.getAddress();  
                    if (Ip != null && Ip instanceof Inet4Address) {  
                        ip = Ip.getHostAddress();  
                    }  
                }  
            }  
        } catch (SocketException e) {  
        	System.out.println("获取本机Ip失败:异常信息:"+e.getMessage());  
        }  
        return ip;  
    }


} 

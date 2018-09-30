package com.cindata.housekeeper.core.common.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SMSSender {
	
	public static void main(String[] args) {
		sendMessage("这是一条测试短信", new String[]{"13936457091"});
	}
	
	/**
	 * 
	 * Title: sendMessage
	 * @author zqb
	 * @date:2015-12-10下午08:28:32
	 * @return:String
	 * @params:@param send_msg
	 * @params:@param tels
	 * @params:@return
	 */
	// 接口发送调用地址：http://admin.sms9.net/houtai/sms.php
	public static String sendMessage(String send_msg, String[] tels) {
		String pathUrl = "http://admin.sms9.net/houtai/sms.php?";
		// 建立连接
		URL url = null;
		HttpURLConnection httpConn = null;
		try {
			
			send_msg = URLEncoder.encode(send_msg, "GBK");

			long timestamp = System.currentTimeMillis() / 1000;
			String cpid = "14286";// 用户ID
			String passwd = "zhuangjiadi";// 密码
			// Md5加密后的字符串：md5(password_timestamp_topsky)
			String passwds = passwd + "_" + timestamp + "_topsky";
			String md5_passwd = new MD5().getMD5(passwds.getBytes());

			String channelid = "16969";
			// String msg = "短信内容";
			String tele = "";
			for (String string : tels) {
				tele += string + ",";
			}

			tele = tele.substring(0, tele.length() - 1);
			if(tele.length()>23){
				tele = tele.substring(0,23);
			}
//			String send_msg_ = new String(new String(send_msg.getBytes("GBK"),"ISO-8859-1").getBytes("ISO-8859-1"), "GBK");
//			String send_msg_ = new String(send_msg.getBytes("ISO-8859-1"),"GBK");

			String params = "cpid=" + cpid + "&password=" + md5_passwd
					+ "&channelid=" + channelid + "&" + "tele=" + tele
					+ "&msg=" + send_msg + "&timestamp=" + timestamp;

			url = new URL(pathUrl +params);
			httpConn = (HttpURLConnection) url.openConnection();

			// //设置连接属性
			httpConn.setDoOutput(true);// 使用 URL 连接进行输出
			httpConn.setDoInput(true);// 使用 URL 连接进行输入
			httpConn.setUseCaches(false);// 忽略缓存
			httpConn.setRequestMethod("POST");// 设置URL请求方法
			// String requestString = "客服端要以以流方式发送到服务端的数据...";

			// 设置请求属性
			// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
			// byte[] requestStringBytes = requestString.getBytes("GBD");
			// httpConn.setRequestProperty("Content-length", ""
			// + requestStringBytes.length);
			httpConn.setRequestProperty("Content-Type",
					"application/octet-stream");
			httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
			httpConn.setRequestProperty("Charset", "GBK");

			// httpConn.getOutputStream().write(params.getBytes());

			// 获得响应状态
			int responseCode = httpConn.getResponseCode();
			StringBuffer sb = new StringBuffer();

			if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
				// 当正确响应时处理数据

				String readLine;
				BufferedReader responseReader;
				// 处理响应流，必须与服务器响应流输出的编码一致
				responseReader = new BufferedReader(new InputStreamReader(
						httpConn.getInputStream(), "utf-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				responseReader.close();
			}
			return sb.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

}

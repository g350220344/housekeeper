package com.cindata.housekeeper.core.common.tools;

import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.ApplyCommunityInfo;
import com.google.common.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.List;

public class OpenapiPoster {

	private static Logger log = LoggerFactory.getLogger(OpenapiPoster.class);

	//public static final String OPENAPI_URL = "https://10.200.8.20:8443/openapi/rest/";
    //public static final String OPENAPI_URL = "http://10.200.8.20:8088/openapi/rest/";
	//public static final String OPENAPI_URL = "http://tt.cindata.cn/openapi/rest/";
	
	public static final String BEIJING_URL = "http://a27.cindata.cn/";
	public static final String BJ_KEY = "1116852DB60440AF4F0C82658E00E2FB";


	//public static final String OPENAPI_URL = "http://192.168.21.13:8400/openapi/rest/"; //tt测试环境部署
	public static final String OPENAPI_URL = "http://sopenapi.cindata.cn/openapi/rest/"; //openapi线上环境

	//public static final String LOGIN_URL = "http://tt.cindata.cn/housekeeper/wx_web/dist/index/login.html"; //tt测试环境URL
	public static final String LOGIN_URL = "http://housekeeper.cindata.cn/housekeeper/wx_web/dist/index/login.html"; //线上环境URL


	//public static final String SP_KEY = "674370ECDC6906C4E0531B03C80A2065";
	//public static final String SP_ID = "100001";
	public static final String SP_KEY = "2IUYW8CNMX5H76T82UIHOXA61PV03L1I";
	public static final String SP_ID = "100003";
	/**
	 * mothed : analysis/getCityMarket
	 */
	public static String getOpenApiUrl(String mothed){
		String ret = null;
		StringBuilder sb = new StringBuilder(OPENAPI_URL);

		sb.append(mothed).append("?")
		.append("spKey=").append(SP_KEY)
		.append("&spId=").append(SP_ID);
		ret = sb.toString();
		log.error("*******openapi request url*******");
		log.error(ret);
		log.error("*******openapi request url*******");
		return ret;
	}
	
	public static String getBJUrl(String mothed){
		String ret = null;
		StringBuilder sb = new StringBuilder(BEIJING_URL);

		sb.append(mothed).append("?")
		.append("key=").append(BJ_KEY);
		ret = sb.toString();
		log.error("*******beijing request url*******");
		log.error(ret);
		log.error("*******beijing request url*******");
		return ret;
	}
	
	public static void main(String[] args) {
//		String url = "https://10.200.8.37:8443/openapi/rest/analysis/getCityMarket?spId=654321&spKey=123456";
//		String a = "aaaaaa";
//		Parameter param = new Parameter();
//    	param.setCityId(2301l);
//    	param.setMonth(Date.valueOf("2017-06-01"));
//    	Gson g = new Gson();
//    	
//		System.out.println(post(param, "analysis/getCityMarket"));
		
		/**/
		Parameter param = new Parameter();
		param.setCommunityName("太古");
		param.setCityId(2301l);
		String resBody = OpenapiPoster.post(param, "community/searchCommunity");
		System.out.println(resBody);
		JSONResult<List<ApplyCommunityInfo>> bean = new JSONResult<List<ApplyCommunityInfo>>();
		bean = (JSONResult<List<ApplyCommunityInfo>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<ApplyCommunityInfo>>>() {
		}.getType());
		List<ApplyCommunityInfo> data = bean.getData();
		System.out.println(data.size());
		
	}

	private final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	};

	private static void trustAllHosts() {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return new java.security.cert.X509Certificate[] {};
			}

			public void checkClientTrusted(X509Certificate[] chain, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] chain, String authType) {
			}
		} };
		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String post(Object data, String mothed) {
		String outputbody = CtrlerUtil.bean2json(data);
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		HttpURLConnection conn;
		String url = getOpenApiUrl(mothed);
		try {
			trustAllHosts();
			URL realUrl = new URL(url);
			// 通过请求地址判断请求类型(http或者是https)
			if (realUrl.getProtocol().toLowerCase().equals("https")) {
				HttpsURLConnection https = (HttpsURLConnection) realUrl.openConnection();
				https.setHostnameVerifier(DO_NOT_VERIFY);
				conn = https;
			} else {
				conn = (HttpURLConnection) realUrl.openConnection();
			}
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "text/json;charset=UTF-8");
			
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
			// 发送请求参数
			out.print(outputbody);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 使用finally块来关闭输出流、输入流
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	public static String postBJ(Object data, String mothed) {
		String outputbody = CtrlerUtil.bean2json(data);
		String result = "";
		PrintWriter out = null;
		BufferedReader in = null;
		HttpURLConnection conn;
		String url = getBJUrl(mothed);
		try {
			trustAllHosts();
			URL realUrl = new URL(url);
			// 通过请求地址判断请求类型(http或者是https)
			if (realUrl.getProtocol().toLowerCase().equals("https")) {
				HttpsURLConnection https = (HttpsURLConnection) realUrl.openConnection();
				https.setHostnameVerifier(DO_NOT_VERIFY);
				conn = https;
			} else {
				conn = (HttpURLConnection) realUrl.openConnection();
			}
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
			// 发送请求参数
			out.print(outputbody);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 使用finally块来关闭输出流、输入流
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}
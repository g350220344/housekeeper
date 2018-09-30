package com.cindata.housekeeper.core.common.tools;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

public class Url2ImageUtil {
	private static final String SERVER_URL = "http://192.168.30.20:5000/picturedeal/api/v1.0/getTelephonenum";
//	private static void main(String[] args) {
//
//		String url = "http://image.58.com/showphone.aspx?t=v55&b=ec6f06&f=ffffff&v=00026B93059F51816036B40559F29F891";
//		System.out.println(getPhoneByUrl(url));
//
//	}

	public static String getPhoneByUrl(String url) {
		String ret = null;
		String jsonStr = "{\"picture_url\":\"" + url + "\"}";

		CloseableHttpClient httpClient = HttpClients.createDefault();
		ResponseHandler<String> responseHandler = new BasicResponseHandler();

		try {

			// 创建HttpClient对象
			httpClient = HttpClients.createDefault();

			// 创建HttpPost对象
			HttpPost httpPost = new HttpPost(SERVER_URL);

			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(5000) // 设置连接超时时间，单位毫秒
					.setConnectionRequestTimeout(2000) // 设置从connect
														// manager获取connection超时时间，单位毫秒
					.setSocketTimeout(30000).build(); // 设置获取数据的超时时间，单位毫秒

			// 设置Post参数
			StringEntity requestEntity = new StringEntity(jsonStr, "UTF-8");
			requestEntity.setContentEncoding("UTF-8");
			httpPost.setHeader("Content-type", "application/json");
			httpPost.setEntity(requestEntity);
			httpPost.setConfig(requestConfig);

			String resultValue = httpClient.execute(httpPost, responseHandler);
			if(resultValue != null && resultValue.trim().length() > 0){
				try {
					JSONObject jo = new JSONObject(resultValue);
					if(jo != null && jo.has("telephone") && !jo.isNull("telephone")){
						ret = StringUtil.toString(jo.get("telephone"), null);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!StringUtil.isNotNullOrEmpty(ret)){
			ret = "-1";
		}
		return ret;
	}

}

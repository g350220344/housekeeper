package com.cindata.housekeeper.core.common.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class CtrlerUtil {
	
	public static String bean2json(Object o){
		String ret = null;
		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		try {
			ret = g.toJson(o);
		} catch (Exception e) {
			e.printStackTrace();
			ret = null;
		}
		return ret;
	}
	
	public static Object json2bean(String json, Type clazz){
		Object ret = null;
		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		try {
			ret = g.fromJson(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			ret = null;
		}
		return ret;
	}

	public static String getRetBody(HttpServletRequest request, Object retBean) {
		String resultStr = null;
		String os = ServletRequestHelper.getParameter(request, "os");
		/*if (request != null) {
			String jsoncallback = request.getParameter("callback");
			if ("1".equals(os) || "3".equals(os)) {
				resultStr = CommonHelper.getGsonObject(retBean);
			} else {
				resultStr = jsoncallback + "(" + CommonHelper.getGsonObject(retBean) + ");";
			}
		}*/
		return CommonHelper.getGsonObject(retBean);
	}
	
	public static String getRetBodyGson(HttpServletRequest request, Object retBean){
		String resultStr = null;
		String os = ServletRequestHelper.getParameter(request, "os");
		if(request != null){
			String jsoncallback = request.getParameter("callback");
//			if(StringUtil.isNotNullOrEmpty(jsoncallback)){
//				resultStr = jsoncallback + "(" + jsonString + ");";
//			}else{
//				resultStr = jsonString;
//			}
			if("1".equals(os) || "3".equals(os)){
				resultStr = CommonHelper.getGsonObject(retBean);
			}else{
				resultStr = jsoncallback + "(" + CommonHelper.getGsonObject(retBean) + ");";
			}
		}
		return resultStr;
	}

	/**
	 * 读取request流
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestBody(HttpServletRequest request) {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != reader) {
					reader.close();
				}
			} catch (IOException e) {

			}
		}
		return sb.toString();
	}

}

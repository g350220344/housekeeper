package com.cindata.housekeeper.core.common.tools;

import com.cindata.housekeeper.core.entity.PayParameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServletRequestHelper {
	public static PayParameter getPayRequestBody(HttpServletRequest request){
		PayParameter ret = null;
		try {
			ServletInputStream is = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			ret = g.fromJson(sb.toString(), PayParameter.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	public static String getWebappPath(HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("");
		path = path.substring(0, path.lastIndexOf("\\") + 1);
		return path;
	}
	
	public static String getBasePath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/";
	}
	
	public static String getParameter(HttpServletRequest request, String name){
		String ret = request.getParameter(name);
		if(ret == null){
			return "";
		}
		return ret.trim();
	}
	public static String getParameterFromSession(HttpServletRequest request, String name){
		if(request == null){
			return "";
		}
		HttpSession session = request.getSession(false);
		String ret = (String) session.getAttribute(name);
		if(ret == null){
			return "";
		}
		return ret.trim();
	}
	
	public static String getParameter(HttpServletRequest request, String name, String def){
		String ret = request.getParameter(name);
		if(ret == null){
			return def;
		}
		ret = ret.trim();
		if(ret.length() == 0){
			return def;
		}
		return ret;
	}
	
	public static String getParameter(HttpServletRequest request, String name, String def, String[] checkArray){
		String ret = request.getParameter(name);
		if(ret == null){
			return def;
		}
		ret = ret.trim();
		if(ret.length() == 0){
			return def;
		}
		
		if(checkArray != null && checkArray.length > 0){
			boolean checkTag = false;
			for (String s : checkArray) {
				if(ret.equals(s)){
					checkTag = true;
				}
			}
			if(!checkTag){
				return def;
			}
		}
		return ret;
	}
	
	public static Integer getParameterInt(HttpServletRequest request, String name, Integer def){
		Integer i = null;
		try {
			i = Integer.valueOf(request.getParameter(name));
		} catch (Exception e) {
			i = def;
		}
		return i;
	}
	
	public static String getParameterNotNull(HttpServletRequest request, String name, String def){
		String ret = request.getParameter(name);
		if(ret == null){
			return def;
		}
		ret = ret.trim();
		if(ret.length() == 0){
			return def;
		}
		return ret;
	}
	
	public static Object getAttribute(HttpServletRequest request, String name, Object def){
		Object ret = request.getAttribute(name);
		if(ret == null){
			return def;
		}
		return ret;
	}
	
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}

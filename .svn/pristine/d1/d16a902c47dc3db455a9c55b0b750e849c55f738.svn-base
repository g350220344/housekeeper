package com.cindata.housekeeper.web.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.CompositeFilter;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.ServletRequestHelper;
import com.cindata.housekeeper.core.common.tools.StringUtil;

/**
 * 安全验证
 * @author yangss
 * @since  2018年01月22日 11时21分
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Component("securityFilter")
public class SecurityFilter extends CompositeFilter {
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest httpRep = (HttpServletRequest) request;
			HttpServletResponse httpRes = (HttpServletResponse) response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.doFilter(request, response, chain);
	}
	
}

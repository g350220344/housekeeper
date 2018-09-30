package com.cindata.housekeeper.core.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestListener implements Filter {

	private static Logger log = LoggerFactory.getLogger(RequestListener.class);

    public RequestListener() {

    }

	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String url = req.getRequestURI();
		String basePath = req.getScheme() + "://"
				+ req.getServerName() + ":" + req.getServerPort()
				+ url;
		log.debug(basePath);
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

package com.cindata.housekeeper.web.filter;

import com.cindata.housekeeper.wx.model.WxUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 登录验证过滤器
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Component("WxLoginFilter")
public class WxLoginFilter implements Filter {
	private static Logger log = LoggerFactory.getLogger(WxLoginFilter.class);

	public static WxUserInfo userInfo;
	/**
	 * 初始化
	 */
	public void init(FilterConfig fc) throws ServletException {
		// FileUtil.createDir("d:/FH/topic/");
	}

	public void destroy() {

	}
	public void doFilter(ServletRequest req, ServletResponse res,
						 FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) res;

		//if (allowedOrigins.contains(originHeader)){
		HttpServletRequest reqs = (HttpServletRequest) req;

		((HttpServletResponse) res).setHeader("Access-Control-Allow-Origin", reqs.getHeader("Origin"));
		//((HttpServletResponse) res).setHeader("Access-Control-Allow-Origin", "*");
		((HttpServletResponse) res).setContentType("application/json;charset=UTF-8");
		((HttpServletResponse) res).setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		((HttpServletResponse) res).setHeader("Access-Control-Max-Age", "3600");
		((HttpServletResponse) res).setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");//表明服务器支持的所有头信息字段
		((HttpServletResponse) res).setHeader("Access-Control-Allow-Credentials", "true"); //如果要把Cookie发到服务器，需要指定Access-Control-Allow-Credentials字段为true;
		((HttpServletResponse) res).setHeader("XDomainRequestAllowed", "1");
		//}
		String[] notFilter = new String[]{"login", "js", "xml", "css", "demo", "img", "images", "fonts", "common", "gateway", "payCallback", "toOrderPage", "show_order"};//过滤字段、路径。。。。。。
		//String urlPath = request.getServletPath();
		//String urlPath = reqs.getRequestURI().substring(reqs.getRequestURI().lastIndexOf("/"), reqs.getRequestURI().length());
		/*Boolean flg = false;
		String []  allowDomain= {"10.200.8.20","http://132.12.11.11:8888","http://123.112.112.12:80","http://123.16.12.23","http://121.12.18.13:10195"};

		Set allowedOrigins= new HashSet(Arrays.asList(allowDomain));
		String ip = PayWxCommonUtil.getClientIp(reqs);
		if(allowedOrigins.contains(ip)){
			flg = true;
		}
		for (String url : notFilter) {
			if ((urlPath.contains(url))) {
				flg = true;
			}
		}
		if (flg) {
			chain.doFilter(req, res);
		} else {
			HttpSession session = reqs.getSession();
			userInfo = (WxUserInfo) session.getAttribute("WxUserInfo"); //登录成功将登录ID放入session中，这里将session取出对比
			if (userInfo == null) {
				log.warn("*******用户登录超时或未登录，请重新登录！*******");
				java.io.PrintWriter out = httpResponse.getWriter();
				JSONResult res1 = new JSONResult();
				res1.setMessage("no ok");
				res1.setStatusCode(99);
				res1.setSuccess(false);
				String resultStr = CtrlerUtil.getRetBody(reqs, res1);
				out.println(resultStr);
				return;
			} else {
				reqs.setAttribute("userId",userInfo.getUserId());
				chain.doFilter(req, res);
			}*/
			chain.doFilter(req, res);
			return;
		}

	/*public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String[] notFilter = new String[] { "login","js","xml","css","demo","img","images","fonts","common","gateway","payCallback","toOrderPage","show_order"};//过滤字段、路径。。。。。。
		String urlPath = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"),request.getRequestURI().length());

		Boolean flg = false;
		for (String url : notFilter) {
			if ((urlPath.contains(url))) {
				flg = true;
			}
		}
		if(request.getRequestURI().indexOf("/sys/")>0||request.getRequestURI().indexOf("/wx/")>0||request.getRequestURI().indexOf("/getCityInfoListBycityName")>0){
            flg = true;
        }
		if(flg){
			chain.doFilter(req, res);
		}else{
			HttpSession session = request.getSession();
			userInfo = (UserInfo)session.getAttribute("WxUserInfo"); //登录成功将登录ID放入session中，这里将session取出对比
			if (userInfo==null) {
				String url = request.getContextPath() + "/page_home/login.html";
				log.warn("*******用户登录超时或未登录，请重新登录！*******");
				java.io.PrintWriter out = response.getWriter();
				JSONResult res1 = new JSONResult();
				res1.setData(url);
				res1.setMessage("no ok");
				res1.setStatusCode(99);
				res1.setSuccess(false);
				String resultStr = CtrlerUtil.getRetBody(request, res1);
				out.println(resultStr);
				return ;

			}else {
                String accessToken = userInfo.getBusinessCard();
                String openid = userInfo.getWxOpenid();
                if(WeixinServer.auth(accessToken,openid)){
                    chain.doFilter(req, res);
                }else{
                    String url = request.getContextPath() + "/page_home/login.html";
                    log.warn("*******用户授权已过期，请重新登录！*******");
                    java.io.PrintWriter out = response.getWriter();
                    JSONResult res1 = new JSONResult();
                    res1.setData(url);
                    res1.setMessage("no ok");
                    res1.setStatusCode(99);
                    res1.setSuccess(false);
                    String resultStr = CtrlerUtil.getRetBody(request, res1);
                    out.println(resultStr);
                    return ;
                }

			}
		}

	}*/
}

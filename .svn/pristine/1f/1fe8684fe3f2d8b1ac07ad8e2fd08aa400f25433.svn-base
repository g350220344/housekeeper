package com.cindata.housekeeper.web.filter;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.web.model.SystemUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * 登录验证过滤器
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Component("LoginFilter")
public class LoginFilter implements Filter {
	private static Logger log = LoggerFactory.getLogger(LoginFilter.class);

	public static SystemUserInfo userInfo;
	/**
	 * 初始化
	 */
	public void init(FilterConfig fc) throws ServletException {
		// FileUtil.createDir("d:/FH/topic/");
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String[] notFilter = new String[] { "login","js","xml","css","demo","img","images","fonts","common","gateway","payCallback","toOrderPage","show_order"};//过滤字段、路径。。。。。。
		//String urlPath = request.getServletPath();
		String urlPath = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"),request.getRequestURI().length());
		Boolean flg = false;
		for (String url : notFilter) {
			if ((urlPath.contains(url))) {
				flg = true;
			}
		}
		if(flg){
			chain.doFilter(req, res);
		}else{
			HttpSession session = request.getSession();
			userInfo = (SystemUserInfo)session.getAttribute("userInfo"); //登录成功将登录ID放入session中，这里将session取出对比
			if (userInfo==null) {
				String url = request.getContextPath() + "/system/login.html";
				log.warn("*******用户登录超时或未登录，请重新登录！*******");
				java.io.PrintWriter out = response.getWriter();
				/*out.println("<html>");
				out.println("<script>");
				out.println("window.open ('"+url+"','_top')");
				out.println("</script>");
				out.println("</html>");*/
				JSONResult res1 = new JSONResult();
				res1.setData(url);
				res1.setMessage("no ok");
				res1.setStatusCode(99);
				res1.setSuccess(false);
				String resultStr = CtrlerUtil.getRetBody(request, res1);
				out.println(resultStr);
				return ;

			}else {
				chain.doFilter(req, res);
			}
		}

	}
}

package com.zdy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zdy.entity.User;


public class SecurityFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig filterCon = null;
	
	public void init(FilterConfig config) throws ServletException {
		filterCon = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
//		ServletContext application = session.getServletContext();
		User userInfo = (User) session.getAttribute("user");
		//System.out.println("111111111111111111");
		//获取在线列表 
//		Map<String,String> onlineUserList = (Map<String,String>) application.getAttribute("");
		//第一次使用前，需要初始化
//		if (onlineUserList == null) {
//			onlineUserList = new HashMap<String, String>();
//			application.setAttribute("", onlineUserList);
//		}
		
		String str=httpRequest.getRequestURL().toString();
		if(userInfo==null){
			if(str.indexOf("/Login.jsp")==-1){
				httpResponse.sendRedirect(httpRequest.getContextPath()+"/Login.jsp");
			}else{
				filterChain .doFilter(request, response);
			}
		}
//		else{
//			String userCode = userInfo.getId().toString();
//			// 用于记录状态 
//			boolean existSec = true;//true：存在当前账号在其他位置登录；false：不存在当前账号在其他位置登录
//			if (onlineUserList.containsKey(userCode) && onlineUserList.get(userCode).equals(session.getId())) {
//				// session值与当前ID匹配,说明同一个用户 
//				existSec = false;
//			}
//			// 存在了第二次登陆，销毁session
//			if (existSec) {
//				session.invalidate(); 
//				response.setCharacterEncoding("UTF-8"); 
//				response.setContentType("text/html; charset=UTF-8"); 
//				//转向的首页，根据自己项目 
//				response.getWriter().print("<script>window.top.location.href='" + httpRequest.getContextPath() + "/login.jsp';alert('该账号已经在别处登录，请联系管理员或关闭ie，重新登录！');</script>"); 
//			} else {
//				filterChain .doFilter(request, response);
//			}
//		}
	}

	public void destroy() {
		filterCon = null;
	}
}

package cn.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 后台拦截器
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		if (uri.startsWith("/admin") && null == request.getSession().getAttribute("loginUser")) {
			request.getSession().setAttribute("errorMsg", "请重新登陆");
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return false;
		} else {
			request.getSession().removeAttribute("errorMsg");
			return true;
		}
	}
}

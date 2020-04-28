package cn.cqsw.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: LoginFilter
 * Description:登录验证
 * date: 2020/4/28 0028 21:44:51
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取拦截路径
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        //获取请求的方法名
        String methodName = request.getParameter("method");
        //放行路径：login.jsp  /user?method=login
        if (uri.contains("login.jsp") || (uri.contains("/system") && "login".equals(methodName))) {
            filterChain.doFilter(request, servletResponse);
        } else {
            HttpSession session = request.getSession();
            Object loginUser = session.getAttribute("login");
            if (loginUser != null) {
                //放行
                filterChain.doFilter(request, servletResponse);
            } else {
                request.setAttribute("logMsg", "尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}

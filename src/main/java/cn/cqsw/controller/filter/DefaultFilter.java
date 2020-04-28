package cn.cqsw.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: DefaultFilter
 * Description:默认放行的过滤器
 * date: 2020/4/28 0028 22:23:03
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class DefaultFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//获取拦截路径
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //放行
        request.setCharacterEncoding("utf-8");
        //放行
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

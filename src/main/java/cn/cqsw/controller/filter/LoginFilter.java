package cn.cqsw.controller.filter;

import cn.cqsw.pojo.BuildingAdmin;
import cn.cqsw.pojo.Student;
import cn.cqsw.pojo.SystemAdmin;
import cn.cqsw.service.BuildingAdminService;
import cn.cqsw.service.StudentService;
import cn.cqsw.service.SystemAdminService;
import cn.cqsw.tool.Tools;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
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
        //从cookies中获取登录状态
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        int level = -1;
        for (int i = 0; i < cookies.length; i++) {
            System.out.println("拦截器获取的cookieName：\"" + cookies[i].getName() + "\",cookieValue：\"" + cookies[i].getValue() + "\"");
            if (cookies[i].getName().equals("username")) {
                username = cookies[i].getValue();
            }
            if (cookies[i].getName().equals("password")) {
                password = cookies[i].getValue();
            }
            if (cookies[i].getName().equals("level")) {
                level = new Integer(cookies[i].getValue());
            }
        }
        System.out.println("拦截器查询到历史登录用户：username:" + username + ",password:" + password + ",level:" + level);
        HttpSession session = request.getSession();
        session.setAttribute("time", Tools.getDate());//设置时间
        if (username != null && !username.trim().equals("") && password != null && !password.trim().equals("") && level != -1) {
            boolean flag = false;
            switch (level) {
                case 0://系统管理员
                    SystemAdmin systemAdmin = new SystemAdmin();
                    systemAdmin.setUid(username);
                    systemAdmin.setPwd(password);
                    //查询用户
                    systemAdmin = new SystemAdminService().selectSystemAdminByUidAndPwd(systemAdmin);
                    if (systemAdmin != null) {
                        //设置登录到会话中
                        flag = true;
                        session.setAttribute("login", systemAdmin);
                    } else {
                    }
                    break;
                case 1://楼宇管理员
                    BuildingAdmin buildingAdmin = new BuildingAdmin();
                    buildingAdmin.setUid(username);
                    buildingAdmin.setPwd(password);
                    buildingAdmin = new BuildingAdminService().selectBuildingAdminByUidAndPwd(buildingAdmin);
                    if (buildingAdmin != null) {
                        flag = true;
                        session.setAttribute("login", buildingAdmin);
                    }
                    break;
                case 2://学生
                    Student student = new Student();
                    student.setSid(username);
                    student.setPwd(password);
                    student = new StudentService().selectStudentBySidAndPwd(student);
                    if (student != null) {
                        flag = true;
                        session.setAttribute("login", student);
                    }
                    break;
            }
            if (flag) {
                session.setAttribute("level", level);
            } else {
                request.setAttribute("logMsg", "帐号密码已修改，登录状态失效！");
            }
        }
        String uri = request.getRequestURI();
        //获取请求的方法名
        String methodName = request.getParameter("method");
        //放行路径：login.jsp  /system?method=login
        if (uri.contains("login.jsp") || (uri.contains("/system") && "login".equals(methodName))) {
            filterChain.doFilter(request, servletResponse);
        } else {
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

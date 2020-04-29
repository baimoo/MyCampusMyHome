package cn.cqsw.controller;

import cn.cqsw.pojo.SystemAdmin;
import cn.cqsw.service.SystemAdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: SystemServlet
 * Description:
 * date: 2020/4/26 0026 23:16:39
 *
 * @author BaiMo
 * @since JDK 1.8
 */
@WebServlet("/system")
public class SystemServlet extends BaseServlet {
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int level = new Integer(req.getParameter("level"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String state = req.getParameter("state");//是否记住密码。选中获取到on
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
                    HttpSession session = req.getSession();
                    session.setAttribute("login", systemAdmin);
                    session.setAttribute("level", level);
                    flag = true;
                    System.out.println("登录成功，跳转到首页");
                    try {
                        req.getRequestDispatcher("/index.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("登录失败，跳转到登录页面");
                    req.setAttribute("logMsg", "帐号或密码错误！");
                    try {
                        req.getRequestDispatcher("/login.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 1:
                break;
            case 2:
                break;
        }
        if (flag && state != null && state.equals("on")) {//如果登录成功，设置cookies
            System.out.println("记住密码，设置cookie");
            Cookie cookieLevel = new Cookie("level", level + "");
            cookieLevel.setPath("/");
            cookieLevel.setMaxAge(60 * 60 * 24 * 7);//设置七天有效期，单位s
            resp.addCookie(cookieLevel);
            Cookie cookieUsername = new Cookie("username", username);
            cookieUsername.setPath("/");
            cookieUsername.setMaxAge(60 * 60 * 24 * 7);//设置七天有效期，单位s
            resp.addCookie(cookieUsername);
            Cookie cookiePassword = new Cookie("password", password);
            cookiePassword.setPath("/");
            cookiePassword.setMaxAge(60 * 60 * 24 * 7);//设置七天有效期，单位s
            resp.addCookie(cookiePassword);
        }

    }

    public void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("退出登录，删除cookie");
        Cookie cookieLevel = new Cookie("level", "");
        cookieLevel.setPath("/");
        cookieLevel.setMaxAge(0);//设置cookie0秒有效期，即删除
        resp.addCookie(cookieLevel);
        Cookie cookieUsername = new Cookie("username", "");
        cookieUsername.setPath("/");
        cookieUsername.setMaxAge(0);//设置cookie0秒有效期，即删除
        resp.addCookie(cookieUsername);
        Cookie cookiePassword = new Cookie("password", "");
        cookiePassword.setPath("/");
        cookiePassword.setMaxAge(0);//设置cookie0秒有效期，即删除
        resp.addCookie(cookiePassword);
        //删除登录会话登录属性
        HttpSession session = req.getSession();
        session.removeAttribute("login");
        session.removeAttribute("level");
        req.setAttribute("logMsg", "请登录后浏览！");
        try {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

}

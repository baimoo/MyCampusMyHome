package cn.cqsw.controller;

import cn.cqsw.pojo.SystemAdmin;
import cn.cqsw.service.SystemAdminService;
import cn.cqsw.tool.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: SystemAdminServlet
 * Description:
 * date: 2020/4/26 0026 23:14:19
 *
 * @author BaiMo
 * @since JDK 1.8
 */
@WebServlet("/systemAdmin")
public class SystemAdminServlet extends BaseServlet {
    //更新系统管理员信息
    public void updateSystemAdmin(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("更新系统管理员信息");
        int said = new Integer(req.getParameter("said"));
        String uid = req.getParameter("uid");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        int sex = new Integer(req.getParameter("sex"));
        SystemAdmin systemAdmin = new SystemAdmin(said, name, uid, pwd, sex);
        int flag = 0;
        try {
            flag = new SystemAdminService().updateSystemAdmin(systemAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "更新失败！");
            } else {
                req.setAttribute("errorMsg", "更新成功！");
            }
            try {
//                req.getRequestDispatcher("/system?method=login").forward(req, resp);
                //设置登录到会话中
                req.getSession().setAttribute("login", new SystemAdminService().selectSystemAdminBySaid(said));
                req.getRequestDispatcher("/index.jsp?time=" + Tools.getRandom(1000, 9999)).forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //更新系统管理员密码信息
    public void updateSystemAdminPwd(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("更新系统管理员密码");
        String pwd = req.getParameter("pwd");
        String pwd2 = req.getParameter("pwd2");
        if (pwd2 != null && !pwd2.trim().equals("")) {
            System.out.println("新密码获取成功");
            HttpSession session = req.getSession();
            SystemAdmin systemAdmin = (SystemAdmin) session.getAttribute("login");
            if (pwd.equals(systemAdmin.getPwd())) {
                System.out.println("旧密码比对成功");
                systemAdmin.setPwd(pwd2);
                int i = new SystemAdminService().updateSystemAdmin(systemAdmin);
                if (i > 0) {
                    //设置登录到会话中
                    req.getSession().setAttribute("login", systemAdmin);
                    req.setAttribute("errorMsg", "修改成功！");
                    Cookie cookiePassword = new Cookie("password", pwd2);
                    cookiePassword.setMaxAge(60 * 60 * 24 * 7);//设置七天有效期，单位s
                    resp.addCookie(cookiePassword);

                } else {
                    req.setAttribute("errorMsg", "修改失败！");
                }
                try {
                    req.getRequestDispatcher("/index.jsp?time=" + Tools.getRandom(1000, 9999)).forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                req.setAttribute("errorMsg", "旧密码错误！修改失败！");
                try {
                    req.getRequestDispatcher("/index.jsp?time=" + Tools.getRandom(1000, 9999)).forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                req.getRequestDispatcher("/index.jsp?time=" + Tools.getRandom(1000, 9999)).forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

package cn.cqsw.controller;

import cn.cqsw.pojo.SystemAdmin;
import cn.cqsw.service.SystemAdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String state = req.getParameter("state");//选中获取到on
        switch (level) {
            case 0://系统管理员
                SystemAdmin systemAdmin = new SystemAdmin();
                systemAdmin.setUid(username);
                systemAdmin.setPwd(password);
                systemAdmin = new SystemAdminService().selectSystemAdminByUidAndPwd(systemAdmin);
                if (systemAdmin != null) {
                    req.setAttribute("login", systemAdmin);
                    req.setAttribute("level", level);
                    try {
                        req.getRequestDispatcher("/index.jsp").forward(req, resp);
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

    }
}

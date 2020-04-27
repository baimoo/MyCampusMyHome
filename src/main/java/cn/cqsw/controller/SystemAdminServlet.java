package cn.cqsw.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void login(HttpServletRequest req, HttpServletResponse resp) {
        req.getParameter("");
    }

}

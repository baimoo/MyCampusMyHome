package cn.cqsw.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * ClassName: BaseServlet
 * Description:Servlet基础类
 * date: 2020/4/21 00021 11:59:27
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置编码集
        req.setCharacterEncoding("UTF-8");
        //获取方法名
        String methodName = req.getParameter("method");
        Method method = null;
        try {
            if (methodName.trim() != "" && (methodName != null)) {
                method=this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                method.invoke(this, req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

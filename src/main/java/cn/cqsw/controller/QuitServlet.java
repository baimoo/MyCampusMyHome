package cn.cqsw.controller;

import cn.cqsw.pojo.BuildingAdmin;
import cn.cqsw.pojo.Quit;
import cn.cqsw.pojo.Student;
import cn.cqsw.service.BuildingService;
import cn.cqsw.service.QuitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: QuitServlet
 * Description:
 * date: 2020/5/4 0004 23:22:39
 *
 * @author BaiMo
 * @since JDK 1.8
 */
@WebServlet("/quit")
public class QuitServlet extends BaseServlet {
    //查询所有记录
    public void selectQuits(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Quit> quits = new QuitService().selectQuits();
            req.setAttribute("quits", quits);

            req.getRequestDispatcher("/quitList.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //添加迁出记录
    public void insertQuit(HttpServletRequest req, HttpServletResponse resp) {
        int flag = 0;
        try {
            String sid = req.getParameter("sid");
            String time = req.getParameter("time");
            String remark = req.getParameter("remark");
            HttpSession session = req.getSession();
            BuildingAdmin buildingAdmin = (BuildingAdmin) session.getAttribute("login");
            Student student = new Student();
            student.setSid(sid);
            student.setState(1);
            Quit quit = new Quit(0, student, time, remark, buildingAdmin);

            flag = new QuitService().insertQuit(quit);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "迁出失败！");
            } else {
                req.setAttribute("errorMsg", "迁出成功！");
            }
            selectQuits(req, resp);
        }

    }
}

package cn.cqsw.controller;

import cn.cqsw.pojo.BuildingAdmin;
import cn.cqsw.pojo.Late;
import cn.cqsw.pojo.Student;
import cn.cqsw.service.LateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName: LateServlet
 * Description:
 * date: 2020/5/5 0005 13:49:15
 *
 * @author BaiMo
 * @since JDK 1.8
 */
@WebServlet("/late")
public class LateServlet extends BaseServlet {
    //查询所有缺寝记录
    public void selectLates(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        int level = (int) session.getAttribute("level");
        List<Late> lates = null;
        if (level == 1) {//楼宇管理员
            try {
                System.out.println("楼宇管理员");
                lates = new LateService().selectLates();
                req.setAttribute("lates", lates);

                req.getRequestDispatcher("/lateList.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (level == 2) {//学生
            Student student = (Student) session.getAttribute("login");
            lates = new LateService().selectLatesBySid2(student.getSid());
            req.setAttribute("lates", lates);
            try {
                req.getRequestDispatcher("/myLateList.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("logMsg", "错误的角色权限！");
            try {
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    //新增缺寝记录
    public void insertLate(HttpServletRequest req, HttpServletResponse resp) {
        int flag = 0;
        try {
            String date = req.getParameter("date");//缺寝时间
            String remark = req.getParameter("remark");//缺寝备注
            String sid = req.getParameter("sid");//学生sid
            Student student = new Student();//学生
            student.setSid(sid);
            BuildingAdmin buildingAdmin = (BuildingAdmin) req.getSession().getAttribute("login");//楼宇管理员
            Late late = new Late(0, date, remark, student, buildingAdmin);

            flag = new LateService().insertLate(late);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "添加失败！");
            } else {
                req.setAttribute("errorMsg", "添加成功！");
            }
            selectLates(req, resp);
        }
    }
}

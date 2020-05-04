package cn.cqsw.controller;

import cn.cqsw.pojo.Building;
import cn.cqsw.pojo.Room;
import cn.cqsw.pojo.Student;
import cn.cqsw.service.BuildingService;
import cn.cqsw.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: StudentServlet
 * Description:学生管理
 * date: 2020/5/3 0003 18:16:40
 *
 * @author BaiMo
 * @since JDK 1.8
 */
@WebServlet("/student")
public class StudentServlet extends BaseServlet {
    //查询所有学生
    public void selectStudents(HttpServletRequest req, HttpServletResponse resp) {
        List<Student> students = new StudentService().selectStudents();
        List<Building> buildings = new BuildingService().selectBuildings();
        HttpSession session = req.getSession();
        session.setAttribute("students", students);
        session.setAttribute("buildings", buildings);
        try {
            req.getRequestDispatcher("/studentList.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //通过sid删除学生
    public void delBuildingAdminByBaid(HttpServletRequest req, HttpServletResponse resp) {
        String sid = req.getParameter("sid");
        int flag = 0;
        try {
            flag = new StudentService().deleteStudentBySid(sid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "删除失败！");
            } else {
                req.setAttribute("errorMsg", "删除成功！");
            }
            selectStudents(req, resp);
        }
    }

    //更新学生信息
    public void updateStudent(HttpServletRequest req, HttpServletResponse resp) {
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String cName = req.getParameter("cName");
        String pwd = req.getParameter("pwd");
        int sex = new Integer(req.getParameter("sex"));
        int rid = new Integer(req.getParameter("rid"));
        Room room = new Room();
        room.setRid(rid);
        Student student = new Student(sid, pwd, name, sex, cName, 0, room, null);
        int flag = 0;
        try {
            flag = new StudentService().updateStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "更新失败！");
            } else {
                req.setAttribute("errorMsg", "更新成功！");
            }
            selectStudents(req, resp);
        }

    }

    //新增学生
    public void insertStudent(HttpServletRequest req, HttpServletResponse resp) {
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String cName = req.getParameter("cName");
        String pwd = req.getParameter("pwd");
        int sex = new Integer(req.getParameter("sex"));
        int rid = new Integer(req.getParameter("rid"));
        Room room = new Room();
        room.setRid(rid);
        Student student = new Student(sid, pwd, name, sex, cName, 0, room, null);
        int flag = 0;
        try {
            flag = new StudentService().insertStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "更新失败！");
            } else {
                req.setAttribute("errorMsg", "更新成功！");
            }
            selectStudents(req, resp);
        }

    }

}

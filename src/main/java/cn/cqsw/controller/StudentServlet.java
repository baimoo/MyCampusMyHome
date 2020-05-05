package cn.cqsw.controller;

import cn.cqsw.pojo.Building;
import cn.cqsw.pojo.Room;
import cn.cqsw.pojo.Student;
import cn.cqsw.service.BuildingService;
import cn.cqsw.service.StudentService;
import cn.cqsw.tool.Tools;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        int level = (int) session.getAttribute("level");
        try {
            if (level != 2) {
                req.getRequestDispatcher("/studentList.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/index.jsp?" + Tools.getRandom(1000, 9999)).forward(req, resp);
            }
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
        int state = new Integer(req.getParameter("state"));
        Room room = null;
        try {
            int rid = new Integer(req.getParameter("rid"));
            room = new Room();
            room.setRid(rid);
        } catch (Exception e) {
            System.err.println("未获取到寝室！");
        } finally {
            Student student = new Student(sid, pwd, name, sex, cName, state, room, null);
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


    }

    //更新学生信息(用于登录)
    public void updateStudent2(HttpServletRequest req, HttpServletResponse resp) {
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String cName = req.getParameter("cName");
        String pwd = req.getParameter("pwd");
        int sex = new Integer(req.getParameter("sex"));
        int state = new Integer(req.getParameter("state"));
        Room room = null;
        try {
            int rid = new Integer(req.getParameter("rid"));
            room = new Room();
            room.setRid(rid);
        } catch (Exception e) {
            System.err.println("未获取到寝室！");
        } finally {
            Student student = new Student(sid, pwd, name, sex, cName, state, room, null);
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
                    //设置登录到会话中
                    req.getSession().setAttribute("login", student);
                }
                selectStudents(req, resp);
            }
        }


    }

    //更新学生密码
    public void updateStudentPwd(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("更新学生密码");
        String pwd = req.getParameter("pwd");
        String pwd2 = req.getParameter("pwd2");
        if (pwd2 != null && !pwd2.trim().equals("")) {
            System.out.println("新密码获取成功" + pwd2);
            HttpSession session = req.getSession();
            Student student = (Student) session.getAttribute("login");
            System.out.println("旧密码比对中");
            if (pwd.equals(student.getPwd())) {
                System.out.println("旧密码比对成功:" + pwd + "==" + student.getPwd());
                student.setPwd(pwd2);
                int i = new StudentService().updateStudent(student);
                if (i > 0) {
                    //设置登录到会话中
                    req.getSession().setAttribute("login", student);
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

    //新增学生
    public void insertStudent(HttpServletRequest req, HttpServletResponse resp) {
        String sid = req.getParameter("sid");
        String name = req.getParameter("name");
        String cName = req.getParameter("cName");
        String pwd = req.getParameter("pwd");
        int sex = new Integer(req.getParameter("sex"));
        Student student = new Student(sid, pwd, name, sex, cName, 2, null, null);
        int flag = 0;
        try {
            flag = new StudentService().insertStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "添加失败！");
            } else {
                req.setAttribute("errorMsg", "添加成功！");
            }
            selectStudents(req, resp);
        }
    }

    //通过寝室rid查询学生（只要学生，单表查询）用于ajax
    public void selectOneBuildings(HttpServletRequest req, HttpServletResponse resp) {
        int rid = new Integer(req.getParameter("rid"));
        List<Student> students = new StudentService().selectStudentsByRid2(rid);
        String s = JSON.toJSONString(students);
        resp.setContentType("text/html;charset=UTF-8");
        try {
            resp.getWriter().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

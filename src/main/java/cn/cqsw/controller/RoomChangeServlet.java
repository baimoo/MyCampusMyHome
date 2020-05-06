package cn.cqsw.controller;

import cn.cqsw.pojo.BuildingAdmin;
import cn.cqsw.pojo.Room;
import cn.cqsw.pojo.RoomChange;
import cn.cqsw.pojo.Student;
import cn.cqsw.service.RoomChangeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: RoomChangeServlet
 * Description:
 * date: 2020/5/5 0005 16:06:15
 *
 * @author BaiMo
 * @since JDK 1.8
 */
@WebServlet("/rc")
public class RoomChangeServlet extends BaseServlet {
    //查询所有调换记录
    public void selectRoomChanges(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<RoomChange> roomChanges = new RoomChangeService().selectRoomChanges();
            HttpSession session = req.getSession();
            session.setAttribute("roomChanges", roomChanges);

            req.getRequestDispatcher("/roomChangeList.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //添加调换记录
    public void insertRoomChange(HttpServletRequest req, HttpServletResponse resp) {
        int flag = 0;
        try {
            String sid = req.getParameter("sid");
            String date = req.getParameter("date");
            String remark = req.getParameter("remark");
            int oldrid = new Integer(req.getParameter("oldrid"));
            int nowrid = new Integer(req.getParameter("nowrid"));
            HttpSession session = req.getSession();
            BuildingAdmin buildingAdmin = (BuildingAdmin) session.getAttribute("login");
            Student student = new Student();
            student.setSid(sid);
            Room oldRoom = new Room();
            oldRoom.setRid(oldrid);
            Room nowRoom = new Room();
            nowRoom.setRid(nowrid);
            student.setRoom(nowRoom);
            RoomChange roomChange = new RoomChange(0, student, date, oldRoom, nowRoom, remark, buildingAdmin);

            flag = new RoomChangeService().insertRoomChange(roomChange);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "调换失败！");
            } else {
                req.setAttribute("errorMsg", "调换成功！");
            }
            selectRoomChanges(req, resp);
        }

    }
}

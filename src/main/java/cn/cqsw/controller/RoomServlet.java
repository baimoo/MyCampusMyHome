package cn.cqsw.controller;

import cn.cqsw.pojo.Building;
import cn.cqsw.pojo.Room;
import cn.cqsw.service.BuildingAdminService;
import cn.cqsw.service.BuildingService;
import cn.cqsw.service.RoomService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: RoomServlet
 * Description:
 * date: 2020/5/3 0003 20:09:03
 *
 * @author BaiMo
 * @since JDK 1.8
 */
@WebServlet("/room")
public class RoomServlet extends BaseServlet {
    //通过楼宇id查询寝室
    public void selectRoomsByBdid(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int bdid = new Integer(req.getParameter("bdid"));
            List<Room> rooms = new RoomService().selectRoomsByBdid(bdid);
            String s = JSON.toJSONString(rooms);
            resp.setContentType("text/html;charset=UTF-8");

            resp.getWriter().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查询所有宿舍
    public void selectRooms(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Room> rooms = new RoomService().selectRooms();
            List<Building> buildings = new BuildingService().selectBuildings();
            HttpSession session = req.getSession();
            session.setAttribute("rooms", rooms);
            session.setAttribute("buildings", buildings);

            req.getRequestDispatcher("/roomList.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过rid删除宿舍
    public void deleteRoomByRid(HttpServletRequest req, HttpServletResponse resp) {
        int flag = 0;
        try {
            int rid = new Integer(req.getParameter("rid"));

            flag = new RoomService().deleteRoomByRid(rid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "删除失败！");
            } else {
                req.setAttribute("errorMsg", "删除成功！");
            }
            selectRooms(req, resp);
        }
    }

    //更新寝室
    public void updateRoom(HttpServletRequest req, HttpServletResponse resp) {
        int flag = 0;
        try {
            int rid = new Integer(req.getParameter("rid"));
            int bdid = new Integer(req.getParameter("bdid"));
            //TODO  无法获取到值
            int num = new Integer(req.getParameter("num"));
            String code = req.getParameter("code");
            String phone = req.getParameter("phone");
            String type = req.getParameter("type");
            Building building = new Building();
            building.setBdid(bdid);
            Room room = new Room(rid, code, building, num, phone, type, null);

            flag = new RoomService().updateRoom(room);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "修改失败！");
            } else {
                req.setAttribute("errorMsg", "修改成功！");
            }
            selectRooms(req, resp);
        }
    }

    //新增寝室
    public void insertRoom(HttpServletRequest req, HttpServletResponse resp) {
        int flag = 0;
        try {
            int bdid = new Integer(req.getParameter("bdid"));
            int num = new Integer(req.getParameter("num"));
            String code = req.getParameter("code");
            String phone = req.getParameter("phone");
            String type = req.getParameter("type");
            Building building = new Building();
            building.setBdid(bdid);
            Room room = new Room(0, code, building, num, phone, type, null);
            flag = new RoomService().insertRoom(room);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "添加失败！");
            } else {
                req.setAttribute("errorMsg", "添加成功！");
            }
            selectRooms(req, resp);
        }
    }
}

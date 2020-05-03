package cn.cqsw.controller;

import cn.cqsw.pojo.Room;
import cn.cqsw.service.RoomService;
import com.alibaba.fastjson.JSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        int bdid = new Integer(req.getParameter("bdid"));
        List<Room> rooms = new RoomService().selectRoomsByBdid(bdid);
        String s = JSON.toJSONString(rooms);
        resp.setContentType("text/html;charset=UTF-8");
        try {
            resp.getWriter().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package cn.cqsw.controller;

import cn.cqsw.pojo.Building;
import cn.cqsw.pojo.BuildingAdmin;
import cn.cqsw.pojo.Room;
import cn.cqsw.service.BuildingAdminService;
import cn.cqsw.service.BuildingService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: BuildingServlet
 * Description:楼宇
 * date: 2020/5/4 0004 12:57:32
 *
 * @author BaiMo
 * @since JDK 1.8
 */
@WebServlet("/bd")
public class BuildingServlet extends BaseServlet {
    //查询所有楼宇
    public void selectBuildings(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Building> buildings = new BuildingService().selectBuildings();
            List<BuildingAdmin> buildingAdmins = new BuildingAdminService().selectBuildingAdmins();
            HttpSession session = req.getSession();
            session.setAttribute("buildings", buildings);
            session.setAttribute("buildingAdmins", buildingAdmins);

            req.getRequestDispatcher("/buildingList.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //通过bdid删除楼宇
    public void deleteBuilding(HttpServletRequest req, HttpServletResponse resp) {
        int flag = 0;
        try {
            int bdid = new Integer(req.getParameter("bdid"));

            flag = new BuildingService().deleteBuildingByBdid(bdid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "删除失败！");
            } else {
                req.setAttribute("errorMsg", "删除成功！");
            }
            selectBuildings(req, resp);
        }
    }

    //更新楼宇
    public void updateBuilding(HttpServletRequest req, HttpServletResponse resp) {
        int flag = 0;
        try {
            int bdid = new Integer(req.getParameter("bdid"));
            int baid = new Integer(req.getParameter("baid"));
            String name = req.getParameter("name");
            String remark = req.getParameter("remark");
            BuildingAdmin buildingAdmin = new BuildingAdmin();
            buildingAdmin.setBaid(baid);
            Building building = new Building(bdid, name, buildingAdmin, remark, null);

            flag = new BuildingService().updateBuilding(building);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "更新失败！");
            } else {
                req.setAttribute("errorMsg", "更新成功！");
            }
            selectBuildings(req, resp);
        }
    }

    //新增楼宇
    public void insertBuilding(HttpServletRequest req, HttpServletResponse resp) {
        int flag = 0;
        try {
            int baid = new Integer(req.getParameter("baid"));
            String name = req.getParameter("name");
            String remark = req.getParameter("remark");
            BuildingAdmin buildingAdmin = new BuildingAdmin();
            buildingAdmin.setBaid(baid);
            Building building = new Building(0, name, buildingAdmin, remark, null);

            flag = new BuildingService().insertBuilding(building);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "添加失败！");
            } else {
                req.setAttribute("errorMsg", "添加成功！");
            }
            selectBuildings(req, resp);
        }
    }

    //查询楼宇（只要楼宇号）用于ajax
    public void selectOneBuildings(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Building> buildings = new BuildingService().selectOneBuildings();
            String s = JSON.toJSONString(buildings);
            resp.setContentType("text/html;charset=UTF-8");

            resp.getWriter().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

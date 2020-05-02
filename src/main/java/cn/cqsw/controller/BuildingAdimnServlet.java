package cn.cqsw.controller;

import cn.cqsw.pojo.BuildingAdmin;
import cn.cqsw.service.BuildingAdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: BuildingAdimnServlet
 * Description:
 * date: 2020/5/2 0002 14:24:35
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class BuildingAdimnServlet extends BaseServlet {
    public void selectBuildingAdmins(HttpServletRequest req, HttpServletResponse resp) {
        List<BuildingAdmin> buildingAdmins = new BuildingAdminService().selectBuildingAdmins();
        HttpSession session = req.getSession();
        session.setAttribute("buildingAdmins", buildingAdmins);
        try {
            req.getRequestDispatcher("/.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

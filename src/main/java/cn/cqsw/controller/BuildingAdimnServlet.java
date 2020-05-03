package cn.cqsw.controller;

import cn.cqsw.pojo.BuildingAdmin;
import cn.cqsw.service.BuildingAdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/ba")
public class BuildingAdimnServlet extends BaseServlet {
    //查询所有楼宇管理员
    public void selectBuildingAdmins(HttpServletRequest req, HttpServletResponse resp) {
        List<BuildingAdmin> buildingAdmins = new BuildingAdminService().selectBuildingAdmins();
        HttpSession session = req.getSession();
        session.setAttribute("buildingAdmins", buildingAdmins);
        try {
            req.getRequestDispatcher("/buildingAdminList.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //通过baid删除楼宇管理员
    public void delBuildingAdminByBaid(HttpServletRequest req, HttpServletResponse resp) {
        int baid = new Integer(req.getParameter("baid"));
        int flag = 0;
        try {
            flag = new BuildingAdminService().deleteBuildingAdminByBaid(baid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "删除失败！");
            } else {
                req.setAttribute("errorMsg", "删除成功！");
            }
            selectBuildingAdmins(req, resp);
        }
    }

    //更新楼宇管理员
    public void updateBuildingAdmin(HttpServletRequest req, HttpServletResponse resp) {
        int baid = new Integer(req.getParameter("baid"));
        String name = req.getParameter("name");
        String uid = req.getParameter("uid");
        String pwd = req.getParameter("pwd");
        int sex = new Integer(req.getParameter("sex"));
        String phone = req.getParameter("phone");
        BuildingAdmin buildingAdmin = new BuildingAdmin(baid, name, uid, pwd, sex, phone, null);
        int flag = 0;
        try {
            flag = new BuildingAdminService().updateBuildingAdmin(buildingAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "更新失败！");
            } else {
                req.setAttribute("errorMsg", "更新成功！");
            }
            selectBuildingAdmins(req, resp);
        }

    }

    //新增楼宇管理员
    public void insertBuildingAdmin(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String uid = req.getParameter("uid");
        String pwd = req.getParameter("pwd");
        int sex = new Integer(req.getParameter("sex"));
        String phone = req.getParameter("phone");
        BuildingAdmin buildingAdmin = new BuildingAdmin(0, name, uid, pwd, sex, phone, null);
        int flag = 0;
        try {
            flag = new BuildingAdminService().insertBuildingAdmin(buildingAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag < 1) {
                req.setAttribute("errorMsg", "添加失败！");
            } else {
                req.setAttribute("errorMsg", "添加成功！");
            }
        }
        selectBuildingAdmins(req, resp);
    }

}

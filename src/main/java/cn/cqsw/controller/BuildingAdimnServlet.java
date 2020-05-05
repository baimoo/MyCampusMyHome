package cn.cqsw.controller;

import cn.cqsw.pojo.BuildingAdmin;
import cn.cqsw.service.BuildingAdminService;
import cn.cqsw.tool.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

    //更新楼宇管理员(用于修改自身)
    public void updateBuildingAdmin2(HttpServletRequest req, HttpServletResponse resp) {
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
                //设置登录到会话中
                req.getSession().setAttribute("login", buildingAdmin);
            }
            selectBuildingAdmins(req, resp);
        }

    }

    //更新楼宇管理员密码
    public void updateBuildingAdminPwd(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("更新楼宇管理员密码");
        String pwd = req.getParameter("pwd");
        String pwd2 = req.getParameter("pwd2");
        if (pwd2 != null && !pwd2.trim().equals("")) {
            System.out.println("新密码获取成功");
            HttpSession session = req.getSession();
            BuildingAdmin buildingAdmin = (BuildingAdmin) session.getAttribute("login");
            if (pwd.equals(buildingAdmin.getPwd())) {
                System.out.println("旧密码比对成功");
                buildingAdmin.setPwd(pwd2);
                int i = new BuildingAdminService().updateBuildingAdmin(buildingAdmin);
                if (i > 0) {
                    //设置登录到会话中
                    req.getSession().setAttribute("login", buildingAdmin);
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

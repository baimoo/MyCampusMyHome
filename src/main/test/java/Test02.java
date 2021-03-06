import cn.cqsw.pojo.BuildingAdmin;
import cn.cqsw.pojo.Room;
import cn.cqsw.pojo.Student;
import cn.cqsw.pojo.SystemAdmin;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: Test02
 * Description:测试类2
 * date: 2020/4/26 0026 21:36:00
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class Test02 extends Test01 {
    @Test//通过帐号密码查询系统管理员
    public void selectSystemAdminByUidAndPwd() {
        SystemAdmin systemAdmin = new SystemAdmin();
        systemAdmin.setUid("baimo");
        systemAdmin.setPwd("123");
        System.out.println(systemAdminMapper.selectSystemAdminByUidAndPwd(systemAdmin));
    }

    @Test//通过帐号密码查询楼宇管理员
    public void selectBuildingAdminByUidAndPwd() {
        BuildingAdmin buildingAdmin = new BuildingAdmin();
        buildingAdmin.setUid("baimo");
        buildingAdmin.setPwd("123");
        System.out.println(buildingAdminMapper.selectBuildingAdminByUidAndPwd(buildingAdmin));
    }

    @Test//查询所有楼宇管理员
    public void selectBuildingAdmins() {
        System.out.println(buildingAdminMapper.selectBuildingAdmins());
    }

    @Test//通过帐号密码查询学生
    public void selectStudentBySidAndPwd() {
        Student student = new Student();
        student.setSid("20185136");
        student.setPwd("123");
        System.out.println(studentMapper.selectStudentBySidAndPwd(student));
    }

    @Test//查询所有学生包含寝室
    public void selectStudents() {
        System.out.println(studentMapper.selectStudents());
    }

    @Test//查询所有楼宇
    public void selectBuildings() {
        System.out.println(buildingMapper.selectBuildings());
    }

    @Test//通过bdid查询寝室
    public void selectRoomsByBdid() {
        List<Room> rooms = roomMapper.selectRoomsByBdid(1);
        System.out.println(rooms);
    }
}

import cn.cqsw.mapper.*;
import cn.cqsw.pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: Test01
 * Description:测试实体类
 * date: 2020/4/24 0024 11:21:05
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class Test01 {
    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    BuildingMapper buildingMapper;
    BuildingAdminMapper buildingAdminMapper;
    LateMapper lateMapper;
    QuitMapper quitMapper;
    RoomMapper roomMapper;
    StudentMapper studentMapper;
    SystemAdminMapper systemAdminMapper;

    @Before
    public void init() throws IOException {
        //读取SqlMapConfig.xml配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂类的工厂对象
        builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(in);
        //获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper的代理对象
        buildingMapper = sqlSession.getMapper(BuildingMapper.class);
        buildingAdminMapper = sqlSession.getMapper(BuildingAdminMapper.class);
        lateMapper = sqlSession.getMapper(LateMapper.class);
        quitMapper = sqlSession.getMapper(QuitMapper.class);
        roomMapper = sqlSession.getMapper(RoomMapper.class);
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        systemAdminMapper = sqlSession.getMapper(SystemAdminMapper.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void insertSystemAdmin() {//新增系统管理员
        SystemAdmin systemAdmin = new SystemAdmin(0, "QQ老冰", "lilang", "123", 1);
        System.out.println(systemAdminMapper.insertSystemAdmin(systemAdmin));
        systemAdmin = new SystemAdmin(0, "白墨", "baimo", "123", 1);
        System.out.println(systemAdminMapper.insertSystemAdmin(systemAdmin));
        systemAdmin = new SystemAdmin(0, "QQ大冰", "baofuqi", "123", 1);
        System.out.println(systemAdminMapper.insertSystemAdmin(systemAdmin));
        systemAdmin = new SystemAdmin(0, "QQ巨冰", "chenfeng", "123", 0);
        System.out.println(systemAdminMapper.insertSystemAdmin(systemAdmin));
        systemAdmin = new SystemAdmin(0, "QQ小冰", "yangxiaojun", "123", 1);
        System.out.println(systemAdminMapper.insertSystemAdmin(systemAdmin));
    }

    @Test
    public void insertBuildingAdmin() {//新增楼宇管理员
        BuildingAdmin buildingAdmin = new BuildingAdmin(0, "QQ老冰", "lilang", "123", 1, "18888888888", null);
        System.out.println(buildingAdminMapper.insertBuildingAdmin(buildingAdmin));
        buildingAdmin = new BuildingAdmin(0, "白墨", "baimo", "123", 1, "18888888888", null);
        System.out.println(buildingAdminMapper.insertBuildingAdmin(buildingAdmin));
        buildingAdmin = new BuildingAdmin(0, "QQ大冰", "baofuqi", "123", 1, "15555555555", null);
        System.out.println(buildingAdminMapper.insertBuildingAdmin(buildingAdmin));
        buildingAdmin = new BuildingAdmin(0, "QQ巨冰", "chenfeng", "123", 0, "16666666666", null);
        System.out.println(buildingAdminMapper.insertBuildingAdmin(buildingAdmin));
        buildingAdmin = new BuildingAdmin(0, "QQ小冰", "yangxiaojun", "123", 1, "17777777777", null);
        System.out.println(buildingAdminMapper.insertBuildingAdmin(buildingAdmin));
    }

    @Test
    public void insertBuilding() {//新增楼宇
        BuildingAdmin buildingAdmin = new BuildingAdmin();
        buildingAdmin.setBaid(1);
        Building building = new Building(0, "A栋", buildingAdmin, "靠近操场，开运动会时会被吵醒", null);
        System.out.println(buildingMapper.insertBuilding(building));
        buildingAdmin.setBaid(2);
        building = new Building(0, "B栋", buildingAdmin, "靠近校门，出校方便，有活动时一样吵闹", null);
        System.out.println(buildingMapper.insertBuilding(building));
        buildingAdmin.setBaid(3);
        building = new Building(0, "C栋", buildingAdmin, "接近食堂，当心长胖", null);
        System.out.println(buildingMapper.insertBuilding(building));
        buildingAdmin.setBaid(4);
        building = new Building(0, "D栋", buildingAdmin, "接近快递点，建议“富家子弟”居住", null);
        System.out.println(buildingMapper.insertBuilding(building));
        buildingAdmin.setBaid(5);
        building = new Building(0, "E栋", buildingAdmin, "靠近校后门，嗯，你懂的", null);
        System.out.println(buildingMapper.insertBuilding(building));
    }

    @Test
    public void insertRoom() {//新增寝室
        Building building = new Building();
        building.setBdid(1);
        Room room = new Room(0, "A1001", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "A1002", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "A1003", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "A1004", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        building.setBdid(2);
        room = new Room(0, "B1001", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "B1002", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "B1003", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "B1004", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        building.setBdid(3);
        room = new Room(0, "C1001", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "C1002", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "C1003", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "C1004", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        building.setBdid(4);
        room = new Room(0, "D1001", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "D1002", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "D1003", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "D1004", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        building.setBdid(5);
        room = new Room(0, "E1001", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "E1002", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "E1003", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
        room = new Room(0, "E1004", building, 4, Tools.getPhone(), "四人间", null);
        System.out.println(roomMapper.insertRoom(room));
    }

    @Test
    public void insertStudent() {//新增学生
        Room room = new Room();
        room.setRid(1);
        Student student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(1);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(1);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(1);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(2);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据2班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(2);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据2班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(3);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据2班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(3);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据2班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(3);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据2班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(4);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(5);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(6);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "计网1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(7);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "计网1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(8);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "计网2班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(9);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "计网2班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(10);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "计网3班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(11);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据3班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(12);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "大数据4班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(13);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "软件1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(14);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "软件2班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(15);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "图文1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(16);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "图文1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(17);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "图文2班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(18);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "图文2班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(19);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "媒体1班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
        room.setRid(20);
        student = new Student(Tools.getRandom(20181000, 20189999) + "", "123", Tools.getName(), Tools.getRandom0Or1(), "媒体2班", 0, room, null);
        System.out.println(studentMapper.insertStudent(student));
    }

    @Test
    public void insertLate() {//新增缺寝记录
        BuildingAdmin buildingAdmin = new BuildingAdmin();
        Student student = new Student();
        buildingAdmin.setBaid(3);
        student.setSid("20185136");
        Late late = new Late(0, "2020-04-01", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-02", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-03", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-04", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-05", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-06", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-07", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-08", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-09", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-10", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-11", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-12", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-13", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-14", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-15", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-16", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-17", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-18", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-19", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-20", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
        late = new Late(0, "2020-04-21", "沉迷学习忘记归寝", student, buildingAdmin);
        lateMapper.insertLate(late);
    }

    @Test
    public void insertQuit() {//添加迁出记录，同时更新学生状态
        try {
            BuildingAdmin buildingAdmin = new BuildingAdmin();
            Student student = new Student();
            buildingAdmin.setBaid(3);
            student.setSid("20185136");
            student.setState(1);
            Quit quit = new Quit(0, student, "2020-04-25", "受不了楼宇管理员的唠叨，干脆搬走", buildingAdmin);
            quitMapper.insertQuit(quit);
            studentMapper.updateStudentStateBySid(student);
        } catch (Exception e) {
            sqlSession.rollback();//事务回滚
            System.out.println("迁出失败！");
            e.printStackTrace();
        }


    }
}

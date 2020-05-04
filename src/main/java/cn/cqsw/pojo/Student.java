package cn.cqsw.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: Student
 * Description:学生表实体类
 * date: 2020/4/23 0023 22:01:23
 *
 * @author BaiMo
 * @since JDK 1.8
 * sid	    varchar(10)	主键	    学号
 * pwd	    varchar(20)	非空	    密码
 * name	    varchar(20)	非空	    学生姓名
 * sex	    int	        非空	    "性别 0/1 女/男"
 * cName	varchar(20)	非空	    班级名
 * state	int	        非空	    "入住状态 0/1/2 入住/迁出/未入住"
 * rid	    int	        外键	    寝室id
 */
public class Student implements Serializable {
    private String sid;//学号
    private String pwd;//密码
    private String name;//学生姓名
    private int sex;//性别 0/1 女/男
    private String cName;//班级名
    private int state;//入住状态 0/1 入住/迁出
    private Room room;//寝室

    private List<Late> lates;//缺寝记录

    public Student(String sid, String pwd, String name, int sex, String cName, int state, Room room, List<Late> lates) {
        this.sid = sid;
        this.pwd = pwd;
        this.name = name;
        this.sex = sex;
        this.cName = cName;
        this.state = state;
        this.room = room;
        this.lates = lates;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", cName='" + cName + '\'' +
                ", state=" + state +
                ", room=" + room +
                ", lates=" + lates +
                '}';
    }

    public List<Late> getLates() {
        return lates;
    }

    public void setLates(List<Late> lates) {
        this.lates = lates;
    }

    public Student() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}

package cn.cqsw.pojo;

import java.io.Serializable;

/**
 * ClassName: Quit
 * Description:迁出表实体类
 * date: 2020/4/23 0023 22:00:15
 *
 * @author BaiMo
 * @since JDK 1.8
 * qid	        int	        主键，自增	编号
 * sid	        varchar(10)	非空，外键	学生id
 * date	        date	    非空	    迁出时间
 * quitRemark	varchar(255)		    迁出备注
 * baid	        int	        非空，外键	楼宇管理员id
 */
public class Quit implements Serializable {
    private int qid;//编号
    private Student student;//学生
    private String date;//迁出时间
    private String quitRemark;//迁出备注
    private BuildingAdmin buildingAdmin;//楼层管理员

    public Quit() {
    }

    public Quit(int qid, Student student, String date, String quitRemark, BuildingAdmin buildingAdmin) {
        this.qid = qid;
        this.student = student;
        this.date = date;
        this.quitRemark = quitRemark;
        this.buildingAdmin = buildingAdmin;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuitRemark() {
        return quitRemark;
    }

    public void setQuitRemark(String quitRemark) {
        this.quitRemark = quitRemark;
    }

    public BuildingAdmin getBuildingAdmin() {
        return buildingAdmin;
    }

    public void setBuildingAdmin(BuildingAdmin buildingAdmin) {
        this.buildingAdmin = buildingAdmin;
    }

    @Override
    public String toString() {
        return "Quit{" +
                "qid=" + qid +
                ", student=" + student +
                ", date='" + date + '\'' +
                ", quitRemark='" + quitRemark + '\'' +
                ", buildingAdmin=" + buildingAdmin +
                '}';
    }
}

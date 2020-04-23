package cn.cqsw.pojo;

import java.io.Serializable;

/**
 * ClassName: Late
 * Description:缺寝表实体类
 * date: 2020/4/23 0023 21:59:53
 *
 * @author BaiMo
 * @since JDK 1.8
 * lid	    int	            主键，自增	编号
 * date	    datetime	    非空	    缺寝时间
 * remark	varchar(255)	非空	    缺寝备注
 * sid	    varchar(10)	    非空，外键	学生id
 */
public class Late implements Serializable {
    private int lid;//编号
    private String date;//缺寝时间
    private String remark;//缺寝备注
    private Student student;//学生

    public Late() {
    }

    public Late(int lid, String date, String remark, Student student) {
        this.lid = lid;
        this.date = date;
        this.remark = remark;
        this.student = student;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Late{" +
                "lid=" + lid +
                ", date='" + date + '\'' +
                ", remark='" + remark + '\'' +
                ", student=" + student +
                '}';
    }
}

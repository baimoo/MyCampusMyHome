package cn.cqsw.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: BuildingAdmin
 * Description:楼宇管理员表实体类
 * date: 2020/4/23 0023 21:59:28
 *
 * @author BaiMo
 * @since JDK 1.8
 * baid	    int	        主键，自增  编号
 * name	    varchar(20)	非空        姓名
 * uid	    varchar(20)	非空	    登录用户名
 * pwd	    varchar(20)	非空	    密码
 * sex	    int	        非空	    性别 0/1 女/男
 * phone	varchar(11)	非空	    电话
 */
public class BuildingAdmin implements Serializable {
    private int baid;//编号
    private String name;//姓名
    private String uid;//登录用户名
    private String pwd;//密码
    private int sex;//性别 0/1 女/男
    private String phone;//电话

    private List<Building> buildings;//楼宇


    public BuildingAdmin(int baid, String name, String uid, String pwd, int sex, String phone, List<Building> buildings) {
        this.baid = baid;
        this.name = name;
        this.uid = uid;
        this.pwd = pwd;
        this.sex = sex;
        this.phone = phone;
        this.buildings = buildings;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    @Override
    public String toString() {
        return "BuildingAdmin{" +
                "baid=" + baid +
                ", name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", buildings=" + buildings +
                '}';
    }

    public BuildingAdmin() {
    }

    public int getBaid() {
        return baid;
    }

    public void setBaid(int baid) {
        this.baid = baid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

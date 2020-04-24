package cn.cqsw.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: Building
 * Description:楼宇表实体类
 * date: 2020/4/23 0023 21:58:56
 *
 * @author BaiMo
 * @since JDK 1.8
 * bdid	    int	        主键，自增	编号
 * name	    varchar(20)	非空	    楼宇名
 * baid	    int	        非空，外键	楼宇管理员id
 * remark	varchar(255)		    楼宇简介
 */
public class Building implements Serializable {
    private int bdid;//编号
    private String name;//楼宇名
    private BuildingAdmin buildingAdmin;//楼宇管理员
    private String remark;//楼宇简介

    private List<Room> rooms;//寝室

    public Building() {
    }

    public Building(int bdid, String name, BuildingAdmin buildingAdmin, String remark, List<Room> rooms) {
        this.bdid = bdid;
        this.name = name;
        this.buildingAdmin = buildingAdmin;
        this.remark = remark;
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Building{" +
                "bdid=" + bdid +
                ", name='" + name + '\'' +
                ", buildingAdmin=" + buildingAdmin +
                ", remark='" + remark + '\'' +
                ", rooms=" + rooms +
                '}';
    }

    public int getBdid() {
        return bdid;
    }

    public void setBdid(int bdid) {
        this.bdid = bdid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildingAdmin getBuildingAdmin() {
        return buildingAdmin;
    }

    public void setBuildingAdmin(BuildingAdmin buildingAdmin) {
        this.buildingAdmin = buildingAdmin;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

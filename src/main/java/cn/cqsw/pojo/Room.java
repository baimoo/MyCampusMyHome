package cn.cqsw.pojo;

import java.io.Serializable;

/**
 * ClassName: Room
 * Description:寝室表实体类
 * date: 2020/4/23 0023 22:00:51
 *
 * @author BaiMo
 * @since JDK 1.8
 * rid	    int	        主键，自增	寝室id
 * code	    varchar(10)	非空，唯一	寝室号
 * bdid	    int	        非空，外键	楼宇id
 * num	    int	        非空	    寝室床位数
 * phone	varchar(11)	非空	    电话
 * type	    varchar(10)	非空	    寝室类型
 */
public class Room implements Serializable {
    private int rid;//寝室id
    private String code;//寝室号
    private Building building;//楼宇
    private int num;//寝室床位数
    private String phone;//电话
    private String type;//寝室类型

    public Room() {
    }

    public Room(int rid, String code, Building building, int num, String phone, String type) {
        this.rid = rid;
        this.code = code;
        this.building = building;
        this.num = num;
        this.phone = phone;
        this.type = type;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", code='" + code + '\'' +
                ", building=" + building +
                ", num=" + num +
                ", phone='" + phone + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

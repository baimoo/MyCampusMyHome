package cn.cqsw.pojo;

/**
 * ClassName: RoomChange
 * Description:寝室调换记录表实体类
 * date: 2020/5/5 0005 14:54:36
 *
 * @author BaiMo
 * @since JDK 1.8
 * rcid	    int	        主键，自增	编号
 * sid	    varchar(10)	非空，外键	学生id
 * date	    date	    非空	    调换时间
 * oldrid	int	        非空，外键	原有寝室
 * nowrid	int	        非空，外键	调换寝室
 * remark	varchar(255)        	备注
 * baid	    int	        非空，外键	楼层管理员id
 */
public class RoomChange {
    private int rcid;
    private Student student;
    private String date;
    private Room oldRoom;
    private Room nowRoom;
    private String remark;
    private BuildingAdmin buildingAdmin;

    public RoomChange(int rcid, Student student, String date, Room oldRoom, Room nowRoom, String remark, BuildingAdmin buildingAdmin) {
        this.rcid = rcid;
        this.student = student;
        this.date = date;
        this.oldRoom = oldRoom;
        this.nowRoom = nowRoom;
        this.remark = remark;
        this.buildingAdmin = buildingAdmin;
    }

    public RoomChange() {
    }

    public int getRcid() {
        return rcid;
    }

    public void setRcid(int rcid) {
        this.rcid = rcid;
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

    public Room getOldRoom() {
        return oldRoom;
    }

    public void setOldRoom(Room oldRoom) {
        this.oldRoom = oldRoom;
    }

    public Room getNowRoom() {
        return nowRoom;
    }

    public void setNowRoom(Room nowRoom) {
        this.nowRoom = nowRoom;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BuildingAdmin getBuildingAdmin() {
        return buildingAdmin;
    }

    public void setBuildingAdmin(BuildingAdmin buildingAdmin) {
        this.buildingAdmin = buildingAdmin;
    }

    @Override
    public String toString() {
        return "RoomChange{" +
                "rcid=" + rcid +
                ", student=" + student +
                ", date='" + date + '\'' +
                ", oldRoom=" + oldRoom +
                ", nowRoom=" + nowRoom +
                ", remark='" + remark + '\'' +
                ", buildingAdmin=" + buildingAdmin +
                '}';
    }
}

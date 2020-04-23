package cn.cqsw.pojo;

import java.io.Serializable;

/**
 * ClassName: SystemAdmin
 * Description:系统管理员表实体类
 * date: 2020/4/21 0021 11:59:40
 *
 * @author BaiMo
 * @since JDK 1.8
 * said	int	        主键，自增	编号
 * name	varchar(20)	非空	    用户名
 * uid	varchar(20)	非空	    管理员帐号
 * pwd	varchar(20)	非空	    密码
 * sex	int		                "性别 0/1 女/男"
 */
public class SystemAdmin implements Serializable {
    private int said;//编号
    private String name;//用户名
    private String uid;//管理员帐号
    private String pwd;//密码
    private int sex;//性别 0/1 女/男

    @Override
    public String toString() {
        return "SystemAdmin{" +
                "said=" + said +
                ", name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                '}';
    }

    public int getSaid() {
        return said;
    }

    public void setSaid(int said) {
        this.said = said;
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

    public SystemAdmin() {
    }

    public SystemAdmin(int said, String name, String uid, String pwd, int sex) {
        this.said = said;
        this.name = name;
        this.uid = uid;
        this.pwd = pwd;
        this.sex = sex;
    }
}

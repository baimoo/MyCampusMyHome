package cn.cqsw.mapper;

import cn.cqsw.pojo.SystemAdmin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * ClassName: SystemAdminMapper
 * Description:系统管理员表实体类接口
 * date: 2020/4/24 0024 22:05:03
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public interface SystemAdminMapper {
    //添加系统管理员
    @Insert("insert into systemAdmin values(default,#{name},#{uid},#{pwd},#{sex})")
    int insertSystemAdmin(SystemAdmin systemAdmin);

    //通过帐号密码查询系统管理员
    @Select("select * from systemAdmin where uid=#{uid} and pwd=#{pwd}")
    SystemAdmin selectSystemAdminByUidAndPwd(SystemAdmin systemAdmin);

    //通过said查询系统管理员
    @Select("select * from systemAdmin where said=#{said}")
    SystemAdmin selectSystemAdminBySaid(int said);

    //更新系统管理员
    int updateSystemAdmin(SystemAdmin systemAdmin);
}

package cn.cqsw.mapper;

import cn.cqsw.pojo.BuildingAdmin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * ClassName: BuildingAdminMapper
 * Description:楼宇管理员表实体类接口
 * date: 2020/4/24 0024 22:12:30
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public interface BuildingAdminMapper {
    //添加楼宇
    @Insert("insert into buildingAdmin values(default,#{name},#{uid},#{pwd},#{sex},#{phone})")
    int insertBuildingAdmin(BuildingAdmin buildingAdmin);

    //更新楼宇
    @Update("update buildingAdmin set name=#{name},uid=#{uid},pwd=#{pwd},sex=#{sex},phone=#{phone} where baid=#{baid}")
    int updateBuildingAdmin(BuildingAdmin buildingAdmin);

    //通过帐号密码查询楼宇管理员
    BuildingAdmin selectBuildingAdminByUidAndPwd(BuildingAdmin buildingAdmin);

    //通过baid查询楼宇管理员
    @Select("select * from buildingAdmin where baid=#{baid}")
    BuildingAdmin selectBuildingAdminByBaid(int baid);

    //通过baid删除楼宇管理员
    @Delete("delete from buildingAdmin where baid=#{baid}")
    int deleteBuildingAdminByBaid(int baid);

    //查询所有楼宇管理员
//    @Select("select * from buildingAdmin where baid=#{baid}")
    List<BuildingAdmin> selectBuildingAdmins();
}

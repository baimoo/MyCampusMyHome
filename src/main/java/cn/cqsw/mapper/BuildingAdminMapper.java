package cn.cqsw.mapper;

import cn.cqsw.pojo.BuildingAdmin;
import org.apache.ibatis.annotations.Insert;

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
}

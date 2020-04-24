package cn.cqsw.mapper;

import cn.cqsw.pojo.Building;
import org.apache.ibatis.annotations.Insert;

/**
 * ClassName: BuildingMapper
 * Description:楼宇表实体类接口
 * date: 2020/4/21 0021 11:58:03
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public interface BuildingMapper {
    //增加楼宇
    @Insert("insert into building values(default,#{name},#{buildingAdmin.baid},#{remark})")
    int insertBuilding(Building building);
    //查询所有楼宇

}

package cn.cqsw.mapper;

import cn.cqsw.pojo.Building;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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

    //更新楼宇
    @Update("update building set name=#{name},baid=#{buildingAdmin.baid},remark=#{remark} where bdid=#{bdid}")
    int updateBuilding(Building building);

    //通过楼宇管理员baid查询楼宇
    @Select("select * from Building where baid=#{baid}")
    List<Building> selectBuildingsByBaid(int baid);
    //查询所有楼宇
    List<Building> selectBuildings();

    //通过楼宇编号bdid查询楼宇
    @Select("select * from Building where bdid=#{bdid}")
    Building selectBuildingByBdid(int bdid);

    //通过楼宇编号bdid删除楼宇
    @Delete("delete from building where bdid=#{bdid}")
    int deleteBuildingByBdid(int bdid);
}

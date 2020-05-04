package cn.cqsw.service;

import cn.cqsw.mapper.BaseDao;
import cn.cqsw.mapper.BuildingMapper;
import cn.cqsw.pojo.Building;

import java.util.List;

/**
 * ClassName: BuildingService
 * Description:
 * date: 2020/5/3 0003 19:18:45
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class BuildingService {
    private BuildingMapper buildingMapper;

    //查询所有楼宇（含寝室）
    public List<Building> selectBuildings() {
        if (buildingMapper == null) {
            buildingMapper = BaseDao.getSqlSession().getMapper(BuildingMapper.class);
        }
        return buildingMapper.selectBuildings();
    }

    //删除楼宇
    public int deleteBuildingByBdid(int bdid) {
        if (buildingMapper == null) {
            buildingMapper = BaseDao.getSqlSession().getMapper(BuildingMapper.class);
        }
        int i = buildingMapper.deleteBuildingByBdid(bdid);
        BaseDao.getSqlSession().commit();
        return i;
    }

    //更新楼宇
    public int updateBuilding(Building building) {
        if (buildingMapper == null) {
            buildingMapper = BaseDao.getSqlSession().getMapper(BuildingMapper.class);
        }
        int i = buildingMapper.updateBuilding(building);
        BaseDao.getSqlSession().commit();
        return i;
    }

    //新增楼宇
    public int insertBuilding(Building building) {
        if (buildingMapper == null) {
            buildingMapper = BaseDao.getSqlSession().getMapper(BuildingMapper.class);
        }
        int i = buildingMapper.insertBuilding(building);
        BaseDao.getSqlSession().commit();
        return i;
    }
}

package cn.cqsw.service;

import cn.cqsw.mapper.BaseDao;
import cn.cqsw.mapper.BuildingAdminMapper;
import cn.cqsw.pojo.BuildingAdmin;

import java.util.List;

/**
 * ClassName: BuildingAdminService
 * Description:
 * date: 2020/5/2 0002 12:32:37
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class BuildingAdminService {
    private BuildingAdminMapper buildingAdminMapper;

    //添加楼宇管理员
    public int insertBuildingAdmin(BuildingAdmin buildingAdmin) {
        if (buildingAdminMapper == null) {
            buildingAdminMapper = BaseDao.getSqlSession().getMapper(BuildingAdminMapper.class);
        }
        int result = buildingAdminMapper.insertBuildingAdmin(buildingAdmin);
        BaseDao.getSqlSession().commit();
        return result;
    }

    //更新楼宇管理员
    public int updateBuildingAdmin(BuildingAdmin buildingAdmin) {
        if (buildingAdminMapper == null) {
            buildingAdminMapper = BaseDao.getSqlSession().getMapper(BuildingAdminMapper.class);
        }
        int result = buildingAdminMapper.updateBuildingAdmin(buildingAdmin);
        BaseDao.getSqlSession().commit();
        return result;
    }

    //通过帐号密码查询楼宇管理员
    public BuildingAdmin selectBuildingAdminByUidAndPwd(BuildingAdmin buildingAdmin) {
        if (buildingAdminMapper == null) {
            buildingAdminMapper = BaseDao.getSqlSession().getMapper(BuildingAdminMapper.class);
        }
        return buildingAdminMapper.selectBuildingAdminByUidAndPwd(buildingAdmin);
    }

    //通过baid查询楼宇管理员
    public BuildingAdmin selectBuildingAdminByBaid(int baid) {
        if (buildingAdminMapper == null) {
            buildingAdminMapper = BaseDao.getSqlSession().getMapper(BuildingAdminMapper.class);
        }
        return buildingAdminMapper.selectBuildingAdminByBaid(baid);

    }

    //通过baid删除楼宇管理员
    public int deleteBuildingAdminByBaid(int baid) {
        if (buildingAdminMapper == null) {
            buildingAdminMapper = BaseDao.getSqlSession().getMapper(BuildingAdminMapper.class);
        }
        int result = buildingAdminMapper.deleteBuildingAdminByBaid(baid);
        BaseDao.getSqlSession().commit();
        return result;

    }

    //查询所有楼宇管理员
    public List<BuildingAdmin> selectBuildingAdmins() {
        if (buildingAdminMapper == null) {
            buildingAdminMapper = BaseDao.getSqlSession().getMapper(BuildingAdminMapper.class);
        }
        return buildingAdminMapper.selectBuildingAdmins();

    }
}

package cn.cqsw.service;

import cn.cqsw.mapper.BaseDao;
import cn.cqsw.mapper.BuildingAdminMapper;
import cn.cqsw.pojo.BuildingAdmin;

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

    //添加楼宇
    public int insertBuildingAdmin(BuildingAdmin buildingAdmin) {
        if (buildingAdminMapper == null) {
            buildingAdminMapper = BaseDao.getSqlSession().getMapper(BuildingAdminMapper.class);
        }
        return buildingAdminMapper.insertBuildingAdmin(buildingAdmin);
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
}

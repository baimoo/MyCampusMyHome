package cn.cqsw.service;

import cn.cqsw.mapper.BaseDao;
import cn.cqsw.mapper.SystemAdminMapper;
import cn.cqsw.pojo.SystemAdmin;

import java.util.List;

/**
 * ClassName: Service
 * Description:
 * date: 2020/4/21 0021 12:00:03
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class SystemAdminService {
    private SystemAdminMapper systemAdminMapper;

    //通过账密查询系统管理员
    public SystemAdmin selectSystemAdminByUidAndPwd(SystemAdmin systemAdmin) {
        if (systemAdminMapper == null) {
            systemAdminMapper = BaseDao.getSqlSession().getMapper(SystemAdminMapper.class);
        }
        return systemAdminMapper.selectSystemAdminByUidAndPwd(systemAdmin);
    }

    //通过said查询系统管理员
    public SystemAdmin selectSystemAdminBySaid(int said) {
        if (systemAdminMapper == null) {
            systemAdminMapper = BaseDao.getSqlSession().getMapper(SystemAdminMapper.class);
        }
        return systemAdminMapper.selectSystemAdminBySaid(said);
    }

    //更新系统管理员
    public int updateSystemAdmin(SystemAdmin systemAdmin) {
        if (systemAdminMapper == null) {
            systemAdminMapper = BaseDao.getSqlSession().getMapper(SystemAdminMapper.class);
        }
        int i = systemAdminMapper.updateSystemAdmin(systemAdmin);
        BaseDao.getSqlSession().commit();
        return i;
    }
}

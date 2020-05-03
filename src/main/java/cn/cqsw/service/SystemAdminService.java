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

    //查询所有系统管理员
    public SystemAdmin selectSystemAdminByUidAndPwd(SystemAdmin systemAdmin) {
        if (systemAdminMapper == null) {
            systemAdminMapper = BaseDao.getSqlSession().getMapper(SystemAdminMapper.class);
        }
        return systemAdminMapper.selectSystemAdminByUidAndPwd(systemAdmin);
    }
}

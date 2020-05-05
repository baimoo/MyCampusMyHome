package cn.cqsw.service;

import cn.cqsw.mapper.BaseDao;
import cn.cqsw.mapper.LateMapper;
import cn.cqsw.pojo.Late;

import java.util.List;

/**
 * ClassName: LateService
 * Description:缺寝记录
 * date: 2020/5/5 0005 13:44:57
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class LateService {
    private LateMapper lateMapper;

    //通过学生学号sid查询缺寝记录
    public List<Late> selectLatesBySid2(String sid) {
        if (lateMapper == null) {
            lateMapper = BaseDao.getSqlSession().getMapper(LateMapper.class);
        }
        return lateMapper.selectLatesBySid2(sid);
    }

    //查询所有缺寝记录
    public List<Late> selectLates() {
        if (lateMapper == null) {
            lateMapper = BaseDao.getSqlSession().getMapper(LateMapper.class);
        }
        return lateMapper.selectLates();
    }

    //新增缺寝记录
    public int insertLate(Late late) {
        if (lateMapper == null) {
            lateMapper = BaseDao.getSqlSession().getMapper(LateMapper.class);
        }
        int i = lateMapper.insertLate(late);
        BaseDao.getSqlSession().commit();
        return i;
    }
}

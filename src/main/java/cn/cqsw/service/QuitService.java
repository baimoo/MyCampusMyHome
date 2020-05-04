package cn.cqsw.service;

import cn.cqsw.mapper.BaseDao;
import cn.cqsw.mapper.QuitMapper;
import cn.cqsw.pojo.Quit;

import java.util.List;

/**
 * ClassName: QuitService
 * Description:
 * date: 2020/5/4 0004 23:22:26
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class QuitService {
    private QuitMapper quitMapper;

    public List<Quit> selectQuits() {
        if (quitMapper == null) {
            quitMapper = BaseDao.getSqlSession().getMapper(QuitMapper.class);
        }
        return quitMapper.selectQuits();
    }

    public int insertQuit(Quit quit) {
        if (quitMapper == null) {
            quitMapper = BaseDao.getSqlSession().getMapper(QuitMapper.class);
        }
        int i = 0;
        try {
            i = quitMapper.insertQuit(quit);
            int i1 = new StudentService().updateStudent(quit.getStudent());
            if (i1 > 0) {
                BaseDao.getSqlSession().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            BaseDao.getSqlSession().rollback();
        } finally {
            return i;
        }
    }
}

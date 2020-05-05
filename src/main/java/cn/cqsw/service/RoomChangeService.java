package cn.cqsw.service;

import cn.cqsw.mapper.BaseDao;
import cn.cqsw.mapper.RoomChangeMapper;
import cn.cqsw.pojo.RoomChange;

import java.util.List;

/**
 * ClassName: RoomChangeService
 * Description:
 * date: 2020/5/5 0005 16:04:04
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class RoomChangeService {
    private RoomChangeMapper roomChangeMapper;

    //查询所有调换记录
    public List<RoomChange> selectRoomChanges() {
        if (roomChangeMapper == null) {
            roomChangeMapper = BaseDao.getSqlSession().getMapper(RoomChangeMapper.class);
        }
        return roomChangeMapper.selectRoomChanges();
    }

    //新增调换记录
    public int insertRoomChange(RoomChange roomChange) {
        if (roomChangeMapper == null) {
            roomChangeMapper = BaseDao.getSqlSession().getMapper(RoomChangeMapper.class);
        }
        int i = roomChangeMapper.insertRoomChange(roomChange);
        int i1 = new StudentService().updateStudent(roomChange.getStudent());
        if (i1 < 1) {
            BaseDao.getSqlSession().rollback();
        } else {
            BaseDao.getSqlSession().commit();
        }
        return i;
    }
}

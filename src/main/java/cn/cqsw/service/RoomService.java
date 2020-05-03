package cn.cqsw.service;

import cn.cqsw.mapper.BaseDao;
import cn.cqsw.mapper.RoomMapper;
import cn.cqsw.pojo.Room;

import java.util.List;

/**
 * ClassName: RoomService
 * Description:
 * date: 2020/5/3 0003 20:06:23
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class RoomService {
    private RoomMapper roomMapper;

    //通过楼宇bdid查询寝室
    public List<Room> selectRoomsByBdid(int bdid) {
        if (roomMapper == null) {
            roomMapper = BaseDao.getSqlSession().getMapper(RoomMapper.class);
        }
        return roomMapper.selectRoomsByBdid(bdid);
    }
}

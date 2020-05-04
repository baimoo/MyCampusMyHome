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

    //查询所有寝室
    public List<Room> selectRooms() {
        if (roomMapper == null) {
            roomMapper = BaseDao.getSqlSession().getMapper(RoomMapper.class);
        }
        return roomMapper.selectRooms();
    }

    //更新寝室
    public int updateRoom(Room room) {
        if (roomMapper == null) {
            roomMapper = BaseDao.getSqlSession().getMapper(RoomMapper.class);
        }
        int i = roomMapper.updateRoom(room);
        BaseDao.getSqlSession().commit();
        return i;
    }

    //新增寝室
    public int insertRoom(Room room) {
        if (roomMapper == null) {
            roomMapper = BaseDao.getSqlSession().getMapper(RoomMapper.class);
        }
        int i = roomMapper.insertRoom(room);
        BaseDao.getSqlSession().commit();
        return i;
    }

    //通过寝室rid删除寝室
    public int deleteRoomByRid(int rid) {
        if (roomMapper == null) {
            roomMapper = BaseDao.getSqlSession().getMapper(RoomMapper.class);
        }
        int i = roomMapper.deleteRoomByRid(rid);
        BaseDao.getSqlSession().commit();
        return i;
    }
}

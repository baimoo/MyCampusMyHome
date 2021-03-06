package cn.cqsw.mapper;

import cn.cqsw.pojo.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * ClassName: RoomMapper
 * Description:寝室表实体类接口
 * date: 2020/4/24 0024 22:10:54
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public interface RoomMapper {
    //新增寝室
    @Insert("insert into room values(default,#{code},#{building.bdid},#{num},#{phone},#{type})")
    int insertRoom(Room room);

    //更新寝室
    @Update("update room set code=#{code},bdid=#{building.bdid},num=#{num},phone=#{phone},type=#{type} where rid=#{rid}")
    int updateRoom(Room room);

    //通过楼宇bdid查询寝室
    List<Room> selectRoomsByBdid(int bdid);

    //通过寝室rid查询寝室
    @Select("select * from room where rid=#{rid} ORDER BY code ASC")
    Room selectRoomByRid(int rid);

    //通过寝室rid删除寝室
    @Delete("delete from room where rid=#{rid}")
    int deleteRoomByRid(int rid);

    //通过寝室rid查询寝室包含楼宇
    Room selectRoomByRid1(int rid);

    //查询所有寝室包含楼宇
    List<Room> selectRooms();
}

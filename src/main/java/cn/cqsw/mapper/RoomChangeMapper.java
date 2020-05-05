package cn.cqsw.mapper;

import cn.cqsw.pojo.RoomChange;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * ClassName: RoomChangeMapper
 * Description:寝室调换记录
 * date: 2020/5/5 0005 14:59:39
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public interface RoomChangeMapper {
    //查询所有调换记录
    List<RoomChange> selectRoomChanges();

    //新增调换记录
    @Insert("insert into roomChange values(default,#{student.sid},#{date},#{oldRoom.rid},#{nowRoom.rid},#{remark},#{buildingAdmin.baid})")
    int insertRoomChange(RoomChange roomChange);
}

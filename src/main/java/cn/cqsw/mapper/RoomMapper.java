package cn.cqsw.mapper;

import cn.cqsw.pojo.Room;
import org.apache.ibatis.annotations.Insert;

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
}

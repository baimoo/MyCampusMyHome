package cn.cqsw.mapper;

import cn.cqsw.pojo.Quit;
import org.apache.ibatis.annotations.Insert;

/**
 * ClassName: QuitMapper
 * Description:迁出表实体类接口
 * date: 2020/4/24 0024 22:10:04
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public interface QuitMapper {
    //新增迁出记录
    @Insert("insert into quit values(default,#{student.sid},#{date},#{quitRemark},#{buildingAdmin.baid})")
    int insertQuit(Quit quit);
}

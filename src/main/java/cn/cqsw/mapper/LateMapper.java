package cn.cqsw.mapper;

import cn.cqsw.pojo.Late;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: LateMapper
 * Description:缺寝表实体类接口
 * date: 2020/4/24 0024 22:06:58
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public interface LateMapper {
    //新增缺寝记录
    @Insert("insert into late values(default,#{date},#{remark},#{student.sid},#{buildingAdmin.baid})")
    int insertLate(Late late);

    //通过学生学号sid查询缺寝记录
    @Select("select * from late where sid=#{sid}")
    List<Late> selectLatesBySid(String sid);

    //通过学生学号sid查询缺寝记录
    List<Late> selectLatesBySid2(String sid);

    //查询所有缺寝记录
    List<Late> selectLates();
}

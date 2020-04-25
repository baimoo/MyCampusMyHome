package cn.cqsw.mapper;

import cn.cqsw.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * ClassName: StudentMapper
 * Description:学生表实体类接口
 * date: 2020/4/24 0024 22:11:31
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public interface StudentMapper {
    //新增学生信息
    @Insert("insert into student values(#{sid},#{pwd},#{name},#{sex},#{cName},#{state},#{room.rid})")
    int insertStudent(Student student);

    //通过学号更新迁出状态
    @Update("update student set state=#{state} where sid=#{sid}")
    int updateStudentStateBySid(Student student);

    //通过学号和密码查询学生
    Student selectStudentBySidAndPwd(Student student);
}

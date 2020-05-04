package cn.cqsw.mapper;

import cn.cqsw.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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
    @Insert("insert into student values(#{sid},#{pwd},#{name},#{sex},#{cName},#{state},null)")
    int insertStudent(Student student);

    //动态更新学生信息
//    @Update("update student set pwd=#{pwd},name=#{name},sex=#{sex},cName=#{cName},state=#{state} where sid=#{sid}")
    int updateStudent(Student student);

    //迁出时更新学生状态信息
//    @Update("update student set state=#{state} where sid=#{sid}")
//    int updateStudentState(Student student);

    //通过学号更新迁出状态
    @Update("update student set state=#{state} where sid=#{sid}")
    int updateStudentStateBySid(Student student);

    //通过学号和密码查询学生
    Student selectStudentBySidAndPwd(Student student);

    //通过学号查询学生
    Student selectStudentBySid(String sid);

    //通过学号查询学生
    @Select("select * from student where sid=#{sid}")
    Student selectStudentBySid2(String sid);

    //通过学号删除学生
    @Delete("delete from student where sid=#{sid}")
    int deleteStudentBySid(String sid);

    //通过寝室rid查询学生
    List<Student> selectStudentsByRid(int rid);

    //查询所有学生包括寝室号
    List<Student> selectStudents();
}

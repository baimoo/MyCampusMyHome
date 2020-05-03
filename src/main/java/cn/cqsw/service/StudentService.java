package cn.cqsw.service;

import cn.cqsw.mapper.BaseDao;
import cn.cqsw.mapper.StudentMapper;
import cn.cqsw.pojo.Student;

import java.util.List;

/**
 * ClassName: StudentService
 * Description:
 * date: 2020/5/2 0002 12:40:25
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class StudentService {
    private StudentMapper studentMapper;

    //通过帐号密码查询学生
    public Student selectStudentBySidAndPwd(Student student) {
        if (studentMapper == null) {
            studentMapper = BaseDao.getSqlSession().getMapper(StudentMapper.class);
        }
        return studentMapper.selectStudentBySidAndPwd(student);
    }

    //查询所有学生
    public List<Student> selectStudents() {
        if (studentMapper == null) {
            studentMapper = BaseDao.getSqlSession().getMapper(StudentMapper.class);
        }
        return studentMapper.selectStudents();
    }

    //通过学号删除学生
    public int deleteStudentBySid(String sid) {
        if (studentMapper == null) {
            studentMapper = BaseDao.getSqlSession().getMapper(StudentMapper.class);
        }
        int result = studentMapper.deleteStudentBySid(sid);
        BaseDao.getSqlSession().commit();
        return result;
    }

    //更新学生信息
    public int updateStudent(Student student) {
        if (studentMapper == null) {
            studentMapper = BaseDao.getSqlSession().getMapper(StudentMapper.class);
        }
        int result = studentMapper.updateStudent(student);
        BaseDao.getSqlSession().commit();
        return result;
    }

    //新增学生信息
    public int insertStudent(Student student) {
        if (studentMapper == null) {
            studentMapper = BaseDao.getSqlSession().getMapper(StudentMapper.class);
        }
        int result = studentMapper.insertStudent(student);
        BaseDao.getSqlSession().commit();
        return result;
    }
}

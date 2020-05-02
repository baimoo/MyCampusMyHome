package cn.cqsw.service;

import cn.cqsw.mapper.BaseDao;
import cn.cqsw.mapper.StudentMapper;
import cn.cqsw.pojo.Student;

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

    public Student selectStudentBySidAndPwd(Student student) {
        if (studentMapper == null) {
            studentMapper = BaseDao.getSqlSession().getMapper(StudentMapper.class);
        }
        return studentMapper.selectStudentBySidAndPwd(student);
    }
}

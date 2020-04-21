package cn.cqsw.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: BaseDao
 * Description:
 * date: 2020/4/21 0021 12:46:11
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class BaseDao {
    static SqlSession sqlSession;
    static InputStream ras;
    static {
        try {
            //加载配置文件获取输入流
            ras = Resources.getResourceAsStream("SqlMapConfig.xml");
            //获取工厂对象
            sqlSession = new SqlSessionFactoryBuilder().build(ras).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        return sqlSession;
    }

    //测试代码
    public static void main(String[] args) {
        System.out.println(getSqlSession().toString());
    }
}

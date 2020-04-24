import cn.cqsw.pojo.Building;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: Test01
 * Description:测试实体类
 * date: 2020/4/24 0024 11:21:05
 *
 * @author BaiMo
 * @since JDK 1.8
 */
public class Test01 {
    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        //读取SqlMapConfig.xml配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂类的工厂对象
        builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(in);
        //获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper的代理对象
        Building = sqlSession.getMapper(Building.class);
    }

    @After
    public void close() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}

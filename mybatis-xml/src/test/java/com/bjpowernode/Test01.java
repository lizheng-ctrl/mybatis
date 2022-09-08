package com.bjpowernode;
import com.bjpowernode.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-23 12:47
 **/
public class Test01 {
    /**
     * @Test 方法启动之前先加载 sqlSessionFactory对象
     */
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "mybatis-config.xml";
        /** 第一步 读取mybatis配置文件*/
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 相当于 User.class.getClassLoader().getResourceAsStream(resource);
        /** 第二步 构建sqlSessionFactory (框架初始化)  == new DefaultSqlSessionFactory 持有configuration的引用*/
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectUserById() {
        SqlSession session = this.sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<Map<String, Object>> maps = mapper.selectAllUserInfo();
        // User(id=1, username=null, password=123456, address= "北京", phone= "1008611")
        maps.stream().forEach(user->{
            System.out.println(user);
        });
    }
}

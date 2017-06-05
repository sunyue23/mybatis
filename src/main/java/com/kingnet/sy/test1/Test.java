package com.kingnet.sy.test1;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by 注定孤独终老 on 2017/6/5.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String resource = "conf.xml";


//        InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        //加载mybatis的配置文件（它也加载关联的映射文件）
        Reader reader = Resources.getResourceAsReader(resource);

        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();

        //映射sql 的标识字符串
        String statement = "com.kingnet.sy.userMapper.getUser";

        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement,2);
        System.out.println(user);


    }
}

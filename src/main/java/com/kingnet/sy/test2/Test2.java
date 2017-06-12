package com.kingnet.sy.test2;


import com.kingnet.sy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by 注定孤独终老 on 2017/6/5.
 */
public class Test2 {

    public Test2() throws IOException {
    }


    @Test
    public void testAdd(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        SqlSession session = sessionFactory.openSession();

        String statement = "com.kingnet.sy.test2.userMapper2"+".addUser";
        int insert = session.insert(statement, new User("sunyue", 25));
        //默认是手动提交的
        session.commit();
        session.close();
        System.out.println(insert);
    }
    @Test
    public void testQuery(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        SqlSession session = sessionFactory.openSession();

        String statement = "com.kingnet.sy.test2.userMapper2.getUser";
        User user = session.selectOne(statement,2);
        session.close();
        System.out.println(user);
    }
    @Test
    public void testUpdate(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        //设置为自动提交
        SqlSession session = sessionFactory.openSession(true);

        String statement = "com.kingnet.sy.test2.userMapper2"+".updateUser";
        int update = session.update(statement, new User(8,"S", 25));
        session.close();
        System.out.println(update);
    }
    @Test
    public void testDelete(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        //设置为自动提交
        SqlSession session = sessionFactory.openSession(true);

        String statement = "com.kingnet.sy.test2.userMapper2"+".deleteUser";
        int delete = session.delete(statement,10);
        session.close();
        System.out.println(delete);
    }

    @Test
    public void getAllUsers(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        //设置为自动提交
        SqlSession session = sessionFactory.openSession();

        String statement = "com.kingnet.sy.test2.userMapper2"+".getAllUsers";
        //User中必须有一个空的构造函数
        List<User> users = session.selectList(statement);

        System.out.println(users);
    }

    @Test
    public void testAdd2(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        SqlSession session = sessionFactory.openSession(true);

        UserMapper mapper = session.getMapper(UserMapper.class);
        int add = mapper.add(new User(-1, "liliang", 25));
        session.close();
        System.out.println(add);

    }
}

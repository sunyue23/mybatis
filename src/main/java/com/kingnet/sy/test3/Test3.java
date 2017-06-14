package com.kingnet.sy.test3;

import com.kingnet.sy.test2.*;
import com.kingnet.sy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunyue on 2017/6/14.
 */
public class Test3 {

    @Test
    public void testGetUser(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        SqlSession session = sessionFactory.openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> allUsers = mapper.getAllUsers();
        allUsers.forEach(user -> {
            System.out.println(user);
        });

    }

    @Test
    public void testAdd(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        SqlSession session = sessionFactory.openSession(true);

        UserMapper mapper = session.getMapper(UserMapper.class);
        int add = mapper.add(new com.kingnet.sy.test3.User(-1, "liliang", 25));
        session.close();
        System.out.println(add);

    }
}

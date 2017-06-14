package com.kingnet.sy.test5;

import com.kingnet.sy.bean.Classes;
import com.kingnet.sy.bean.Order;
import com.kingnet.sy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * Created by sunyue on 2017/6/14.
 */
public class Test5 {
    @Test
    public void getClasses1(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        SqlSession session = sessionFactory.openSession(true);
        String statement = "com.kingnet.sy.test5.ClassMapper.getClass";
        Classes classes = session.selectOne(statement,2);
        System.out.println(classes);
    }
    @Test
    public void getClasses2(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        SqlSession session = sessionFactory.openSession(true);
        String statement = "com.kingnet.sy.test5.ClassMapper.getClass2";
        Classes classes = session.selectOne(statement,1);
        System.out.println(classes);
    }
}

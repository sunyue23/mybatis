package com.kingnet.sy.util;

import com.kingnet.sy.test1.Test;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by sunyue on 2017/6/6.
 */
public class MybatisUtils {
    public static SqlSessionFactory getSessionFactory() {
        String resource = "conf.xml";


        InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        return sessionFactory;

    }
}

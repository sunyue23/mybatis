package com.kingnet.sy.test4;

import com.kingnet.sy.bean.Order;
import com.kingnet.sy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * Created by sunyue on 2017/6/14.
 */
public class Test4 {
    @Test
    public void getOrder(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        SqlSession session = sessionFactory.openSession(true);
        String statement = "com.kingnet.sy.test4.orderMapper.getOrder2";
        Order order = session.selectOne(statement,2);
        System.out.println(order);
    }
}

package com.kingnet.sy.test7;

import com.kingnet.sy.bean.Classes;
import com.kingnet.sy.bean.ConditionUser;
import com.kingnet.sy.bean.User;
import com.kingnet.sy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunyue on 2017/6/14.
 */
public class Test7 {
    @Test
    public void getClasses1(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        SqlSession session = sessionFactory.openSession(true);
        String statement = "com.kingnet.sy.test7.duserMapper.getUser";

        String name = "o";
        name = null;
        ConditionUser conditionUser = new ConditionUser("%"+name+"%",13,18);
        List<User> users = session.selectList(statement,conditionUser);
        System.out.println(users);
    }

}

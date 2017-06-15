package com.kingnet.sy.test8;

import com.kingnet.sy.bean.ConditionUser;
import com.kingnet.sy.bean.User;
import com.kingnet.sy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunyue on 2017/6/14.
 */
public class Test8 {
    @Test
    public void getCount(){
        SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
        SqlSession session = sessionFactory.openSession(true);
        String statement = "com.kingnet.sy.test8.puserMapper.getUserCount";

        Map<String ,Integer> parameterMap = new HashMap<>();
        parameterMap.put("sexid",1);
        parameterMap.put("usercount",-1);

        session.selectOne(statement,parameterMap);

        int count = parameterMap.get("usercount");
        System.out.println(count);
    }

}

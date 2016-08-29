package com.xyj.template;

import com.google.common.base.Stopwatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * Created by xiaoyijian on 2016/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class TestJdbc {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select t.user_id,t.code,t.name,t1.password from m_users t join m_users2 t1 on t.user_id = t1.user_id");
        for(Map<String, Object> map :list) {
            System.out.println(map.get("user_id")+","+map.get("password")+","+map.get("code")+","+map.get("name"));
        }
    }
}

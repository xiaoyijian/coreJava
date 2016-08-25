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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
        List<Object[]> list = new ArrayList<>();
        for(int i=0;i<100;i++) {
            Object[] obj = new Object[]{ UUID.randomUUID().toString(),"145454"};
            list.add(obj);
        }
        Stopwatch sw=Stopwatch.createStarted();
        jdbcTemplate.batchUpdate("INSERT INTO `d_areas` VALUES (?, ?)",list);
        Integer result = jdbcTemplate.queryForObject("select count(*) from d_areas", Integer.class);

        System.out.println(result+" "+sw.elapsed(TimeUnit.MILLISECONDS)+"ms");
    }
}

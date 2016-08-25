package com.xyj.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiaoyijian on 2016/8/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Configuration
@PropertySource("classpath:test.properties")
public class TestConfig {
    @Autowired
    private Environment env;

    @Test
    public void testEnv(){
        String test = env.getProperty("test");
        System.out.println(test);
    }
}
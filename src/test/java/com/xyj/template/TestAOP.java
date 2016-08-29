package com.xyj.template;

import com.xyj.log.HelloWrold;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiaoyijian on 2016/8/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestAOP {
    @Autowired
    private HelloWrold helloWrold;

    @Test
    public void test() {
        helloWrold.say();
    }
}

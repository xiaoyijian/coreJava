package com.xyj.h2.manager;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyj.h2.dao.UserDao;
import com.xyj.h2.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoyijian
 * @date 2019/06/16
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:spring-test-datasource-h2.xml" })
public class UserManagerTest {

    @Resource
    private UserManager userManager;

    @Test
    public void test() {
        try {
            userManager.add();
        } catch (Exception e) {
            log.error("error", e);
        }

        UserEntity result = userManager.getById(2L);
        log.info("result:{}", result);
    }

}

package com.xyj.h2.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyj.h2.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoyijian
 * @date 2019/06/16
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:spring-test-datasource-h2.xml" })
public class UserDaoTest {

    @Resource
    private UserDao userDao;


    @Test
    public void test() {
        log.info("beging .....");
        UserEntity entity = new UserEntity();
        entity.setName("jack");
        userDao.insert(entity);
        UserEntity result = userDao.getById(entity.getId());
        log.info("result:{}", result);
    }

}

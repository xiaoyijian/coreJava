package com.xyj.h2.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xyj.h2.dao.UserDao;
import com.xyj.h2.entity.UserEntity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoyijian
 * @date 2019/06/16
 */
@Data
@Component
@Slf4j
public class UserManager {
    @Resource
    private UserDao userDao;

    @Transactional
    public void add() {
        log.info("2344");
        UserEntity entity = new UserEntity();
        entity.setName("jack");
        userDao.insert(entity);
        throw new RuntimeException("test");
    }

    public UserEntity getById(Long id) {
        return userDao.getById(id);
    }
}

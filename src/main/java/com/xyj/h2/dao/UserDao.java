package com.xyj.h2.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xyj.h2.entity.UserEntity;

/**
 * @author xiaoyijian
 * @date 2019/06/16
 */
public interface UserDao {

    UserEntity getById(@Param("id") Long id);

    int insert(UserEntity entity);
}

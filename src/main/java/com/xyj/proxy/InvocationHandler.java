package com.xyj.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xiaoyijian
 * @date 2019/05/31
 */
public interface InvocationHandler {
    void invoke(Object handler, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
}

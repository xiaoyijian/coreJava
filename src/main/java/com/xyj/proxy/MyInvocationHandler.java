package com.xyj.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.xyj.proxy.pojo.Animal;

/**
 * @author xiaoyijian
 * @date 2019/05/31
 */
public class MyInvocationHandler implements InvocationHandler {
    private Animal animal;

    public MyInvocationHandler(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void invoke(Object handler, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        method.invoke(animal, args);
    }
}

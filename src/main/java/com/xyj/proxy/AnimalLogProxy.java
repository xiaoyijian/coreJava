package com.xyj.proxy;

import com.xyj.proxy.pojo.Animal;

/**
 * 日志代理类
 * 聚合方式，可以代理Animal的所有实现类
 * 代理类如果没有实现接口，就会没有办法实现多个代理逻辑
 * @author xiaoyijian
 * @date 2019/05/31
 */
public class AnimalLogProxy implements Animal {
    private Animal animal;

    public AnimalLogProxy(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void sleep() {
        System.out.println("begin sleep..");
        animal.sleep();
        System.out.println("end sleep..");

    }

    @Override
    public void play() {
        animal.play();
    }
}

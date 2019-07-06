package com.xyj.proxy;

import com.xyj.proxy.pojo.Animal;

/**
 * 耗时代理类，记录方法执行时间
 * 聚合方式，可以代理Animal的所有实现类
 *
 * @author xiaoyijian
 * @date 2019/05/31
 */
public class AnimalTimeProxy implements Animal {
    private Animal animal;

    public AnimalTimeProxy(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void sleep() {
        long start = System.currentTimeMillis();
        animal.sleep();
        long cost = System.currentTimeMillis() - start;
        System.out.println("time cost:" + cost);

    }

    @Override
    public void play() {
        animal.play();
    }
}

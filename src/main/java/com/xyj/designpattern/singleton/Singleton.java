package com.xyj.designpattern.singleton;

/**
 * 单例
 * 饿汉加载
 * 缺点：不能延迟实例化，加载类就实例化
 * @author xiaoyijian
 * @date 2019/06/14
 */
public class Singleton {
    private Singleton() {
        System.out.println("Singleton created");
    }

    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}

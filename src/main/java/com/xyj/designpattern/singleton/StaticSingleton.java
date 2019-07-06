package com.xyj.designpattern.singleton;

/**
 * 静态内部类实现
 * 线程安全，不用加同步关键字
 * @author xiaoyijian
 * @date 2019/06/14
 */
public class StaticSingleton {

    private StaticSingleton() {
        System.out.println("Singleton created");
    }


    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();

    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}

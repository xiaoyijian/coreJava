package com.xyj.designpattern.singleton;

/**
 * 单例
 * 延迟加载
 * 同步关键字会有开销
 */
public class LazySingleton1 {
    private LazySingleton1() {
        System.out.println("Singleton created");
    }

    private static LazySingleton1 instance = null;

    public static synchronized LazySingleton1 getInstance() {
        if (instance == null) {
            instance = new LazySingleton1();
        }
        return instance;
    }
}

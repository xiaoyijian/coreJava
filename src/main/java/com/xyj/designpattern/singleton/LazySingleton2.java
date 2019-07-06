package com.xyj.designpattern.singleton;

/**
 * 单例
 * 延迟加载
 * 双重校验，没有拿到实例化对象时再同步操作
 */
public class LazySingleton2 {
    private LazySingleton2() {
        System.out.println("Singleton created");
    }

    /**
     * volatile
     * 可以禁止指令重排序 避免使用未初始化完毕的对象
     */
    private static volatile LazySingleton2 instance = null;

    public static LazySingleton2 getInstance() {
        if (instance == null) {
            synchronized (LazySingleton2.class) {
                if (instance == null) {//进入后如果已经实例化完成，则可以跳过这步
                    instance = new LazySingleton2();
                    //实例化对象一般分3不， 指令重排序 多线程会发布未初始化的对象
                    // 1、分配内存空间
                    // 2、初始化对象
                    // 3、将内存空间的地址赋给对应的引用

                }
            }
        }
        return instance;
    }
}

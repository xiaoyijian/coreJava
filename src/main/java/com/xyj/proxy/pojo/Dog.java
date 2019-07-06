package com.xyj.proxy.pojo;

import com.xyj.proxy.pojo.Animal;

/**
 * @author xiaoyijian
 * @date 2019/05/31
 */
public class Dog implements Animal {
    @Override
    public void sleep() {
        System.out.println("dog sleep...");
    }

    @Override
    public void play() {
        System.out.println("cat play...");

    }
}

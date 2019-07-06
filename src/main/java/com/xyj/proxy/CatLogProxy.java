package com.xyj.proxy;

import com.xyj.proxy.pojo.Cat;

/**
 * 继承方式实现代理，没有办法代理Animal所有实现类，每个都要写一个
 * @author xiaoyijian
 * @date 2019/05/31
 */
public class CatLogProxy extends Cat {

    @Override
    public void sleep() {
        System.out.println("begin sleep...");
        super.sleep();
        System.out.println("end sleep...");
    }
}

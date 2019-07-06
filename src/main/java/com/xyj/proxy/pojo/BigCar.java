package com.xyj.proxy.pojo;

/**
 * @author xiaoyijian
 * @date 2019/05/31
 */
public class BigCar implements Car {
    @Override
    public void move() {
        System.out.println("bigCar move..");
    }
}

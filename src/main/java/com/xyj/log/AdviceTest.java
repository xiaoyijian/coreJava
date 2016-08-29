package com.xyj.log;

import org.aspectj.lang.annotation.Before;

/**
 * Created by xiaoyijian on 2016/8/26.
 */
public class AdviceTest {

    public void before(){
        System.out.println("before say");
    }
    public void after(){
        System.out.println("after say");
    }

    public void afterReturning(){
        System.out.println("after returning");
    }
    public void afterThrowing(){
        System.out.println("after throwing");
    }
}

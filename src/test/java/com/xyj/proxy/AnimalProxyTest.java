package com.xyj.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.xyj.proxy.pojo.Animal;
import com.xyj.proxy.pojo.Cat;

/**
 * @author xiaoyijian
 * @date 2019/05/31
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AnimalProxyTest {

    /**
     * 继承的方式，只能代理cat，不能代理dog
     * 如果想调整多个代理的顺序，需要修改代理的代码
     */
    @Test
    public void test_extend_proxy() {
        Cat cat = new CatLogProxy();
        cat.sleep();
    }

    /**
     * 可以代理所有Animal的实现类
     * 如果想调整代理顺序，直接修改调用顺序，改动小
     * 但是还不能代理其他接口，每个接口都要写代理类
     */
    @Test
    public void test_animal_proxy() {
        Animal cat = new Cat();
        AnimalLogProxy proxy1 = new AnimalLogProxy(cat);
        AnimalTimeProxy proxy2 = new AnimalTimeProxy(proxy1);
        proxy2.sleep();
    }

}

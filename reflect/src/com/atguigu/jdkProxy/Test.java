package com.atguigu.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-09-03 14:25
 **/
public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(cat);
        /**   被代理类和代理类要实现同一接口   所以要传参数 接口类型   被代理类的类型*/
        Animal animal = (Animal) Proxy.newProxyInstance(cat.getClass().getClassLoader(), cat.getClass().getInterfaces(), myInvocationHandler);
        animal.eat("鱼");

    }
}

package com.bjpowernode.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 此类不是真正的代理类,真正的代理类在jvm内存中,看不见摸不着,真正的代理类名字一般是以$Proxy开头的
 */

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-24 10:54
 **/
public class TargetProxy implements InvocationHandler {
    /** 持有目标接口的引用,动态代理适配各种目标类型,所以类型为Object*/
    private Object target;

    /** 使用构造方法对目标接口的引用实现初始化 */
    public TargetProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置增强(通知)-------------");
        /** 中间是调用目标接口的方法*/
        Object invoke = method.invoke(target, args);
        System.out.println("后置增强(通知)-------------");
        return invoke;
    }


    /**
     * 获取真正的代理类
     * @author lizheng
     * @date 2022/08/24 11:23
     * @param interfaces
     * @return T
     */
    public <T> T getProxy(Class interfaces) {
        //1 jvm内存中生成一个class类
        //2 根据该class类反射创建一个代理对象
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(),
                new Class<?>[]{interfaces},
                this);
    }
}

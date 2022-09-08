package com.bjpowernode.proxy.javassist;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.invoke.MethodHandleInfo;
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
public class TargetProxy implements MethodHandler {

    /**
     * 获取代理对象
     * @author lizheng
     * @date 2022/09/03 17:50
     * @param clazz
     * @return java.lang.Object
     */
    public Object getProxy(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        //代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        //设置需要创建子类的父类
        proxyFactory.setSuperclass(clazz);
        Object proxy = proxyFactory.createClass().newInstance();
        //在调用目标方法时,javassist 会回调MethodHandler 接口方法拦截
        //来实现你自己的代理逻辑，类似于JDKz中的InvocationHandler 接口
        ((ProxyObject)proxy).setHandler(this);
        return proxy;

    }

    @Override
    public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
        System.out.println("开启事务----------------");
        //调用目标类的方法
        Object result = proceed.invoke(self,args);
        System.out.println("提交事务---------------");
        return result;
    }
}

package com.bjpowernode.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-24 13:35
 **/
public class TargetProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName()+"数据缓存start。。。。。。。。");
        //调用目标方法
        Object result = methodProxy.invokeSuper(obj, args);
        //就像mybatis一样。需要自己实现接口
        //System.out.println("sayHello");
        System.out.println(method.getName()+"数据缓存end。。。。。。。。");
        return result;
    }

    /**
     * 真正的代理类
     * @author lizheng
     * @date 2022/08/24 13:50
     * @return com.bjpowernode.proxy.cglib.TargetInterface
     */
    public <T> T getProxy(Class<T> clazz) {
        //字节码增强的一个类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(clazz);
        //enhancer.setInterfaces(new Class[]{clazz});
        //设置回调类
        enhancer.setCallback(this);
        //创建代理类
        return (T)enhancer.create();
    }
}

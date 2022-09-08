package com.bjpowernode.proxy.jdk;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-24 11:13
 **/
public class Test01 {
    public static void main(String[] args) {

        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        //使用动态代理
        //获取代理类
        TargetProxy proxyClass = new TargetProxy(new TargetInterfaceImpl());
        //真正的代理对象
        TargetInterface proxy = (TargetInterface) proxyClass.getProxy(TargetInterface.class);
    }
}

package com.bjpowernode.proxy.javassist;

/**
 * @program: SSM-SOURCECODE
 * @description: 测试类
 * @author: LZ
 * @create: 2022-09-03 17:54
 **/
public class Test01 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        TargetProxy proxy = new TargetProxy();
        TargetInterfaceImpl targetClass = (TargetInterfaceImpl)proxy.getProxy(TargetInterfaceImpl.class);
        targetClass.sayHi("张无忌");
    }
}

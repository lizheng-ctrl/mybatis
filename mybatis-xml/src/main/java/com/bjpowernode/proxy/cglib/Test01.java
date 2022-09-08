package com.bjpowernode.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-24 13:47
 **/
public class Test01 {
    public static void main(String[] args) {


        //通过参数设置，把动态代理生成的class 文件输出到磁盘上，默认是不会输出到磁盘的，所以动态代理生成的类我们是看不见摸不着的
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:/code");
        TargetProxy targetProxy = new TargetProxy();
        //拿到目标类的代理类
        TargetInterface targetInterface = targetProxy.getProxy(TargetInterfaceImpl.class);
        targetInterface.sayHello("赵敏");
        targetInterface.sayThank("张三");

    }
}

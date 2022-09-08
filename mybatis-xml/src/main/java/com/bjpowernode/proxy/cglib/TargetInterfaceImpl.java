package com.bjpowernode.proxy.cglib;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-24 13:33
 **/
public class TargetInterfaceImpl implements TargetInterface {
    @Override
    public String sayHello(String name) {
        return "Hello"+name;
    }

    @Override
    public String sayThank(String name) {
        return "Thank"+name;
    }
}

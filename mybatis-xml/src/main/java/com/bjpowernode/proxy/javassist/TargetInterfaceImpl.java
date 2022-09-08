package com.bjpowernode.proxy.javassist;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-24 10:53
 **/
public class TargetInterfaceImpl implements TargetInterface {
    @Override
    public void sayHi(String name) {
        System.out.println("你好"+name);

    }

    @Override
    public void work() {

    }
}

package com.atguigu.jdkProxy;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-09-03 14:24
 **/
public class Cat implements Animal {
    @Override
    public void eat(String food) {
        System.out.println("猫喜欢吃"+food);
    }
}

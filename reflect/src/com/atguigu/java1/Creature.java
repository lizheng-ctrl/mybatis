package com.atguigu.java1;

import java.io.Serializable;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-09-01 21:30
 **/
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    private void eat(){
        System.out.println("生物吃东西");
    }
}

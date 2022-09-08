package com.bjpowernode.proxy.statics;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-24 09:56
 **/
public class Test01 {
    public static void main(String[] args) {
        HoseProxy hoseProxy = new HoseProxy(new Host());
        hoseProxy.rentHouse();
        hoseProxy.getBackHouse();
    }
}

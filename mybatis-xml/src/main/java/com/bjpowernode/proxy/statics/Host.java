package com.bjpowernode.proxy.statics;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-24 09:50
 **/
public class Host implements RentHouse {
    @Override
    public void rentHouse() {
        System.out.println("房东把房子租了出去");
    }

    @Override
    public void getBackHouse() {
        System.out.println("房东收回房子");
    }
}

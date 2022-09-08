package com.bjpowernode.proxy.statics;
/**  代理类执行方法时进行相应的更改,这样便不会更改源代码 实现相同的需求*/
/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-24 09:51
 **/
public class HoseProxy implements RentHouse{

    private Host host;

    public HoseProxy(Host host){
        this.host = host;
    }

    @Override
    public void rentHouse() {
        System.out.println("今天天气不错");
        host.rentHouse();
    }


    @Override
    public void getBackHouse() {
        System.out.println("房东要自己住房子");
        host.getBackHouse();
    }

}

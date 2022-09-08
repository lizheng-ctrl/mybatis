package com.bjpowernode.proxy.cglib;
/**
 *
 * @author lizheng
 * @date 2022/08/24 13:29
 */
public interface TargetInterface {
    /**
     * sayHello
     * @author lizheng
     * @date 2022/08/24 13:32
     * @param name
     * @return java.lang.String
     */
    public String sayHello(String name);
    /**
     * sayThank
     * @author lizheng
     * @date 2022/08/24 13:32
     * @param name
     * @return java.lang.String
     */
    public String sayThank(String name);
}

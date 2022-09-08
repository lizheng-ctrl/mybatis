package com.atguigu.java1;

import java.io.FileNotFoundException;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-09-01 21:27
 **/
@MyAnnotation
public class Person extends Creature<String> implements Comparable,MyInterface{

    private String name;

    int age;

    public int id;

    public Person(){

    }
    @MyAnnotation(value="abc")
    Person(String name){
        this.name =name;
    }

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @MyAnnotation
    private String show(String nation) throws NullPointerException, FileNotFoundException {
        System.out.println("我的国籍是:"+nation);
        return nation;
    }

    private static void Hello(String name){
        System.out.println("你好"+name);
    }



    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

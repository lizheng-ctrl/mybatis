package com.atguigu.java1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-09-02 17:04
 **/
public class ReflectionTest {
    @Test
    public void test01() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        person.setAge(10);
        System.out.println(person.getAge());
        System.out.println("**************");
        Field id = personClass.getField("id");
        id.set(person,1);
        System.out.println(person.toString());
    }


    @Test
    public void test02() throws Exception {
        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person person = personClass.newInstance();
        person.setName("xiao li");
        System.out.println(person);
        System.out.println("****************************");
        //getDeclaredField(String fieldName) 获取运行时类中指定变量名的属性
        Field name = personClass.getDeclaredField("name");
        //设置属性可以访问
        name.setAccessible(true);
        //设置指定对象 此属性的值
        name.set(person,"zhangsan");
        System.out.println(person);
    }


    /** 操作运行时类的方法*/
    @Test
    public void test03() throws Exception{
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        Method show = personClass.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        Object o = show.invoke(person, "中国");
        System.out.println((String)o);

        //操作静态方法
        System.out.println("*************************");
        Method hello = personClass.getDeclaredMethod("Hello", String.class);
        hello.setAccessible(true);
        hello.invoke(null,"张三");
    }

    @Test
    public void test04(){

    }




}

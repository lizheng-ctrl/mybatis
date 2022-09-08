package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-31 23:06
 **/
public class ReflectTest {
    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        Person person1 = constructor.newInstance("tom", 12);
        System.out.println(person1.toString());

        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(person1,10);
        System.out.println(person1.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person1);


        System.out.println("*****************************************");
        //通过反射，可以调用Person类的私有结构
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person  p1 = cons1.newInstance("Jerry");
        System.out.println(p1.toString());


        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeiMei");
        System.out.println(p1);
    }
    @Test
    public void test02() throws ClassNotFoundException {
        /** 四种获取Class实例的方法*/
        /** 1*/
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        /** 2*/
        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass);
        /** 3*/
        Class<?> aClass1 = Class.forName("com.atguigu.java.Person");
        System.out.println(aClass1);


        /**4*/
        System.out.println("**********************");
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class<?> aClass2 = contextClassLoader.loadClass("com.atguigu.java.Person");
        System.out.println(aClass2);
    }

}


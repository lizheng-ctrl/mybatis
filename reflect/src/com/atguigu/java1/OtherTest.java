package com.atguigu.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-09-02 15:07
 **/
public class OtherTest {
    /** 获取构造器结构*/
    @Test
    public void test01(){
        Class<Person> personClass = Person.class;

        //getConstructors() 获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }


        System.out.println("************************");
        //获取当前运行时类 中所有的构造器  包括私有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    /**  获取运行时类的父类*/
    @Test
    public void test02(){
        Class<Person> personClass = Person.class;
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }


    /**  获取运行时类带泛型的父类*/
    @Test
    public void test03(){
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }


    /**  获取运行时类父类的泛型*/
    @Test
    public void test04(){
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }


    /** 获取运行时类的接口*/
    @Test
    public void test05(){
        Class<Person> personClass = Person.class;
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }



    /** 获取运行时类  所在的包*/

    @Test
    public void test06(){
        Class<Person> personClass = Person.class;
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
    }

    /** 获取运行时类 所声明的注解*/
    @Test
    public void test07(){
        Class<Person> personClass = Person.class;
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

}

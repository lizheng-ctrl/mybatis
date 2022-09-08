package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/**
 * @program: SSM-SOURCECODE
 * @description: 通过反射创建对应的运行时类的对象
 * @author: LZ
 * @create: 2022-09-01 20:43
 **/
public class NewInstanceTest {
    @Test
    public void test01() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;
        /** newInstance 调用此方法 创建运行时类的对象，内部调用了运行时类的空参的构造方法*/
        /**
         *使用此方法要求：
         *1 运行时类必须提供空参的构造器
         *2 空参构造器不能声明为private
         */


        /**
         * 在javabean中要求提供一个public的空参构造器、原因:
         * 1 便于通过反射，创建运行时类的对象
         * 2 便于子类继承运行时类时，默认调用super()时，保证父类有此构造器
         */
        Person person = personClass.newInstance();
        System.out.println(person);
    }


    @Test
    public void test02(){
        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num){
                case 0:
                    classPath="java.util.Date";
                    break;
                case 1:
                    classPath="java.lang.Object";
                    break;
                case 2:
                    classPath="com.atguigu.java.Person";
                    break;

            }
            Object newInstance = null;
            try {
                newInstance = getNewInstance(classPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(newInstance);
        }
    }



    /** 体会发射的动态性*/
    private Object getNewInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName(classPath);
        Object o = aClass.newInstance();
        return o;

    }
}

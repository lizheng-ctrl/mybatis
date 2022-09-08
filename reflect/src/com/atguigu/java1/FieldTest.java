package com.atguigu.java1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @program: SSM-SOURCECODE
 * @description: 获取当前运行时类的属性结构
 * @author: LZ
 * @create: 2022-09-01 21:52
 **/
public class FieldTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        // 获取属性 结构
        //getFields(): 获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

       //getDeclaredFields(): 获取当前运行时类中声明的所有属性。(不包含父类中声明的属性)
        System.out.println("********************");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }
    //权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //1.权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.print(Modifier.toString(modifiers)+"\t");
            //2.数据类型
            Class<?> type = declaredField.getType();
            System.out.print(type.getName()+"\t");

            //3.变量名
            String name = declaredField.getName();
            System.out.println(name);
        }

    }
}

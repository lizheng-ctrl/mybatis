package com.atguigu.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @program: SSM-SOURCECODE
 * @description: 获取运行时类的方法结构
 * @author: LZ
 * @create: 2022-09-01 22:31
 **/
public class MethodTest {
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        //getMethods(): 获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("*******************");

        //getDeclaredMethods(): 获取当前运行时类中声明的所有方法（不包含父类中声明的方法）
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    /**
     * @Xxxx
     * 权限修饰符 返回值 方法名（参数类型1，形参名1，。。。。。） throws XxxException{}
     */
    @Test
    public void test02(){
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
           //1.获取方法声明的注解
            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.print(annotation+"\t");
            }


            //2.获取权限修饰符
            System.out.print(Modifier.toString(declaredMethod.getModifiers())+"\t");

            //3.返回值类型
            Class<?> returnType = declaredMethod.getReturnType();
            System.out.print(returnType.getName()+"\t");


            //4.方法名
            System.out.print(declaredMethod.getName());
            System.out.print("(");
            //5 形参列表
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            if(!(parameterTypes==null||parameterTypes.length==0)){
                for (int i = 0; i < parameterTypes.length; i++) {
                    if(i==parameterTypes.length-1){
                        System.out.print(parameterTypes[i].getName()+" args_"+i);
                    }else{
                        System.out.print(parameterTypes[i].getName()+" args_"+i+",");
                    }
                }
            }
            System.out.print(")");

            //6 抛出的异常
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            if(!(exceptionTypes==null||exceptionTypes.length==0)){
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i==exceptionTypes.length-1){
                        System.out.print(exceptionTypes[i].getName());
                    }else{
                        System.out.print(exceptionTypes[i].getName()+",");
                    }
                }
            }

            System.out.println();



        }
    }
}

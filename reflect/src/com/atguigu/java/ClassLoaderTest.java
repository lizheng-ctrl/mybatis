package com.atguigu.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-09-01 17:38
 **/
public class ClassLoaderTest {
    @Test
    public void test01() throws IOException {

        /** 通过类加载器加载文件*/
        Properties properties = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        /** 默认加载 src文件夹下的文件*/
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(resourceAsStream);
        String user = properties.getProperty("user");
        String name = properties.getProperty("password");
        System.out.println("user="+user+"name="+name);

    }

    @Test
    public void test02() throws IOException {
        /** 通过FileInputStream 流加载文件*/
        Properties properties = new Properties();
        /** 文件路径反斜杠 同计算机路径  默认加载module下的文件*/
        FileInputStream fileInputStream = new FileInputStream("src\\jdbc.properties");
        properties.load(fileInputStream);
        String user = properties.getProperty("user");
        String name = properties.getProperty("password");
        System.out.println("user="+user+"name="+name);
    }
}

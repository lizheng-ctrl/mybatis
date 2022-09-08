package com.bjpowernode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SSM-SOURCECODE
 * @description:
 * @author: LZ
 * @create: 2022-08-23 12:53
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id ;
    private int age;
    private String email;
    private String name;
}

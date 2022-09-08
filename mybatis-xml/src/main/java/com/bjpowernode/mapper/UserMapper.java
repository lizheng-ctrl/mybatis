package com.bjpowernode.mapper;

import com.bjpowernode.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 查询所有的用户信息
     * @author lizheng
     * @date 2022/08/23 13:16
     * @return java.util.List<com.bjpowernode.entity.User>
     */
    List<Map<String,Object>> selectAllUserInfo();
}

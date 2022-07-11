package com.yang.service;

import com.yang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    //判断登录
    User LoginByNameAndPwd(Map<String,Object> map);

    List<User> selectAllUsers();

    //修改密码
    int updateUserPwd(String newPwd,String id);

}

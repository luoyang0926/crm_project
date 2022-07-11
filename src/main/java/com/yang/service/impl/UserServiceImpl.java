package com.yang.service.impl;

import com.yang.mapper.UserMapper;
import com.yang.pojo.User;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User LoginByNameAndPwd(Map<String, Object> map) {
        return userMapper.selectUserByUsernameAPwd(map);
    }

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public int updateUserPwd(String newPwd, String id) {
        return userMapper.updateUserPwd(newPwd,id);
    }
}

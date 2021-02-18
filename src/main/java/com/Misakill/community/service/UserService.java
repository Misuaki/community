package com.Misakill.community.service;

import com.Misakill.community.dao.UserMapper;
import com.Misakill.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int userId){
        return userMapper.selectById(userId);
    }
}

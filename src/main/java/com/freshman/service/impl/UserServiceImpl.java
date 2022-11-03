package com.freshman.service.impl;

import com.freshman.controller.Result;
import com.freshman.mapper.UserMapper;
import com.freshman.pojo.User;
import com.freshman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Result addUser(User user) {
        if (this.userMapper.selectByUserName(user.getUsername()) == null){
            // 没有用户,可以添加
            userMapper.insertUser(user);
            return new Result(1,"register successful!");
        }else {
            return new Result(-1,"The user name already exists");
        }
    }

    @Override
    public Result login(User user) {
        if(userMapper.selectUser(user)!= null){
            // 有这一号人
            return new Result(100,"login successful");
        }else {
            return new Result(-100,"login fail");
        }
    }
}

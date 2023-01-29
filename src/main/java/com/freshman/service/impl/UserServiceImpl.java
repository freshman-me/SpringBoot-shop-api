package com.freshman.service.impl;

import com.freshman.controller.Code;
import com.freshman.controller.Result;
import com.freshman.jwt.JwtUtil;
import com.freshman.mapper.UserMapper;
import com.freshman.pojo.User;
import com.freshman.service.UserService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Result addUser(User user) {
        if (this.userMapper.selectByUserName(user.getUsername()) == null){
            // md5加密
            System.out.println(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            // 没有用户,可以添加
            byte[] bytes = user.getPassword().getBytes();
            Base64 base64 = new Base64();
            byte[] encode = base64.encode(bytes);
            String password = new String(encode);
            user.setPassword(password);
            userMapper.insertUser(user);
            return new Result(Code.REGISTER_SUCCESS,"register successful!");
        }else {
            return new Result(Code.REGISTER_FAIL,"The username already exists");
        }
    }

    @Override
    public Result login(User user) throws Exception {
        byte[] bytes = user.getPassword().getBytes();
        Base64 base64 = new Base64();
        byte[] encode = base64.encode(bytes);
        String password = new String(encode);
        user.setPassword(password);
        if(userMapper.selectUser(user)!= null){
            // 有这一号人
            //        添加token返回
            User user1 = userMapper.selectUser(user);
            System.out.println(user1);
            return new Result(Code.LOGIN_SUCCESS,"login successful",JwtUtil.createToken(user1));
        }else {
            return new Result(Code.LOGIN_FAIL,"login fail");
        }
    }
}

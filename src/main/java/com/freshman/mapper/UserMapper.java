package com.freshman.mapper;

import com.freshman.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
public interface UserMapper {

    // 根据用户名查找用户
    User selectByUserName(@Param("userName")String userName);


    // 添加用户
    void insertUser(User user);

    // 用户登录
    User selectUser(User user);

}

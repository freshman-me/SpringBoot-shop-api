package com.freshman.service;

import com.freshman.controller.Result;
import com.freshman.pojo.User;

public interface UserService {

    Result addUser(User user);

    Result login(User user);
}

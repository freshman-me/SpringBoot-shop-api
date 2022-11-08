package com.freshman.controller;

import com.freshman.pojo.User;
import com.freshman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user){
       return userService.addUser(user);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) throws Exception {
        return userService.login(user);
    }
}

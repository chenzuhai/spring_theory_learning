package com.spring.demo1.controller;

import com.spring.demo1.MyAutoWired;
import com.spring.demo1.service.UserService;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2021/1/21 15:06
 */
public class UserController {

    @MyAutoWired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

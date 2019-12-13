package com.wayne.frame.controller;

import com.zx.springboottest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xzhang
 * @date 2019-12-11 13:12
 **/
@RestController
@RequestMapping("/")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @RequestMapping("/findByUserName")
    public String findByUserName(String name) {
        return userService.findByUserName(name).toString();
    }


}

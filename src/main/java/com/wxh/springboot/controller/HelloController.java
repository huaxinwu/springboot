/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wxh.springboot.domain.User;

/**
 * springboot测试
 * @author wxh
 * @version $Id: HelloController.java, v 0.1 2017年11月6日 下午3:36:43 wxh Exp $
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello SpringBoot!";
    }

    // 默认返回数据格式是json，json接口开发
    @RequestMapping("/get/user")
    public User getUser() {
        User user = new User();
        user.setName("张三");
        user.setPwd("123456");
        return user;
    }
}

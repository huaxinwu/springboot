/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wxh.springboot.domain.User;
import com.wxh.springboot.repository.UserRepository;

/**
 * UserRepository crud test
 * @author wxh
 * @version $Id: UserRepositoryTest.java, v 0.1 2017年11月7日 上午10:37:24 wxh Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserRepository() throws Exception {

        userRepository.deleteAll();

        User user = new User();
        user.setName("张三");
        user.setPwd("123456");

        User user2 = new User();
        user2.setName("李四");
        user2.setPwd("321654");

        userRepository.save(user);
        userRepository.save(user2);

        // 断言验证数据真实性
        Assert.assertEquals(2, userRepository.findAll().size());

        userRepository.delete(userRepository.findByName("张三"));

    }

    /**
     * jpa基本查询
     */
    @Test
    public void testBaseQuery() {
        User user = new User();

        userRepository.findAll();
        userRepository.findOne(1L);
        userRepository.save(user);
        userRepository.delete(user);
        userRepository.count();
        userRepository.exists(1L);
        // 其他方法
    }
}

/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.springboot;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.wxh.springboot.domain.User;

/**
 * redis做缓存测试
 * @author wxh
 * @version $Id: RedisTest.java, v 0.1 2017年11月7日 下午2:05:12 wxh Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate       redisTemplate;

    @Test
    public void testRedisTemplate() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        User user = new User();
        user.setName("aaa");
        user.setPwd("1111");

        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }

}

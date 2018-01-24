/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wxh.springboot.domain.User;

/**
 * 使用jpa进行增删改查
 * @author wxh
 * @version $Id: UserRepository.java, v 0.1 2017年11月7日 上午10:33:25 wxh Exp $
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名查询用户信息--自定义查询
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 根据用户名和密码查询用户信息--自定义查询
     * @param name
     * @param pwd
     * @return
     */
    User findByNameAndPwd(String name, String pwd);

    /**
     * 根据用户名模糊查询用户信息
     * @param name
     * @return
     */
    List<User> findByNameLike(String name);

    /**
     * 自定义sql查询
     * @param id
     */
    @Transactional
    @Modifying
    @Query("delete from User where uId = ?1")
    void deleteByUid(Long uId);
}

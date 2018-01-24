/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.springboot.repository;

import org.springframework.data.repository.Repository;

import com.wxh.springboot.domain.User;

/**
 * mysql封装的jpa
 * @author wxh
 * @version $Id: JpaUserRepository.java, v 0.1 2017年11月7日 下午4:39:04 wxh Exp $
 */
public interface JpaUserRepository extends Repository<User, Long> {

}

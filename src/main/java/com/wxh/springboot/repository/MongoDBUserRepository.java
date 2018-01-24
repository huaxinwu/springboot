/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.springboot.repository;

import org.springframework.data.repository.Repository;

import com.wxh.springboot.domain.User;

/**
 * MongoDB封装的jpa
 * @author wxh
 * @version $Id: MongoDBUserRepository.java, v 0.1 2017年11月7日 下午4:42:22 wxh Exp $
 */
public interface MongoDBUserRepository extends Repository<User, Long> {

}

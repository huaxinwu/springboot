/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.springboot.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * spring-data-jpa注解映射实体和表的关系
 * @author wxh
 * @version $Id: User.java, v 0.1 2017年11月6日 下午5:07:35 wxh Exp $
 */
@Entity
public class User implements Serializable {

    /** */
    private static final long serialVersionUID = -4471137477410880838L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long              uId;
    @Basic
    @Column(nullable = true)
    private String            name;
    @Basic
    @Column(nullable = true)
    private String            pwd;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
        result = prime * result + ((uId == null) ? 0 : uId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (pwd == null) {
            if (other.pwd != null)
                return false;
        } else if (!pwd.equals(other.pwd))
            return false;
        if (uId == null) {
            if (other.uId != null)
                return false;
        } else if (!uId.equals(other.uId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [uId=" + uId + ", name=" + name + ", pwd=" + pwd + "]";
    }

}

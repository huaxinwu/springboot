/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置
 * 通过@Value获取配置文件的值
 * @author wxh
 * @version $Id: NeoProperites.java, v 0.1 2017年11月7日 上午10:07:20 wxh Exp $
 */
@Configuration
public class NeoProperties {
    @Value("${com.neo.title}")
    private String title;
    @Value("{com.neo.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

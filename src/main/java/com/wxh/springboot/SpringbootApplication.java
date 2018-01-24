package com.wxh.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    /**
     * springboot默认启动端口是8080
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
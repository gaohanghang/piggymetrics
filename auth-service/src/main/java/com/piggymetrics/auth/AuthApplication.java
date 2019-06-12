package com.piggymetrics.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer  // 使用EnableResourceServer注解开启资源服务
@EnableDiscoveryClient // 服务发现客户端
@EnableGlobalMethodSecurity(prePostEnabled = true) // 使用表达式时间方法级别的安全性 4个注解可用
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}

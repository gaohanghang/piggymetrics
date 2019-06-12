package com.piggymetrics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-05-18 09:37
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭打开的csrf保护
        http.csrf().disable();
        /*
            authorizeRequests() 配置路径拦截，表明路径访问所对应的权限，角色，认证信息。
            允许所有用户访问"/actuator/**"
         */
        http
            .authorizeRequests()
                .antMatchers("/actuator/**").permitAll()
                // 其他地址的访问均需验证权限
                .anyRequest().authenticated()
            .and()
                // 进行http Basic认证
                .httpBasic()
        ;
    }
}

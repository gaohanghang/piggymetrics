package com.piggymetrics.auth.controller;

import com.piggymetrics.auth.domain.User;
import com.piggymetrics.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-05-22 12:42
 **/
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        return principal;
    }

    // 注解, 在方法调用之前, 基于表达式结果来限制方法的使用.
    @PreAuthorize("#oauth2.hasScope('server')")
    @PostMapping
    public void createUser(@Valid @RequestBody User user) {
        userService.create(user);
    }
}

package com.piggymetrics.auth.service;

import com.piggymetrics.auth.domain.User;
import com.piggymetrics.auth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-05-21 23:44
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository repository;

    @Override
    public void create(User user) {

        Optional<User> existing = repository.findById(user.getUsername());
        existing.ifPresent(it -> {
            throw new IllegalArgumentException("user already exists: " + it.getUsername());
        });

        // 加密
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        repository.save(user);

        log.info("new user has been created: {}", user.getUsername());
    }
}

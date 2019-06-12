package com.piggymetrics.auth.repository;

import com.piggymetrics.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2019-05-21 23:41
 **/
@Repository
public interface UserRepository extends CrudRepository<User, String> {
}

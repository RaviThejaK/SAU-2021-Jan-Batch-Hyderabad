package com.accolite.restapi_au.repository;

import com.accolite.restapi_au.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findUserByEmailId(String s);
}

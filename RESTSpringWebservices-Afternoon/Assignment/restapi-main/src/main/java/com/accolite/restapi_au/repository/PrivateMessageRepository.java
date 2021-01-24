package com.accolite.restapi_au.repository;

import com.accolite.restapi_au.entity.PrivateMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrivateMessageRepository extends JpaRepository<PrivateMessage, Integer> {
    public List<PrivateMessage> findByUserId(Integer userId);
    public Optional<PrivateMessage> findById(Integer id);
}

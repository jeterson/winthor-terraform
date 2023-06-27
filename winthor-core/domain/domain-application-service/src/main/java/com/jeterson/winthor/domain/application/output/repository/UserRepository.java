package com.jeterson.winthor.domain.application.output.repository;

import com.jeterson.winthor.domain.core.entities.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
}

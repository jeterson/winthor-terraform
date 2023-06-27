package com.jeterson.winthor.domain.application.input.service;

import com.jeterson.winthor.domain.core.entities.User;

public interface UserApplicationService {

    User findByUsername(String username);
}

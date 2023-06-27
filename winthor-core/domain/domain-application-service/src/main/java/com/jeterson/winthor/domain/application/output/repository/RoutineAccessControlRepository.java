package com.jeterson.winthor.domain.application.output.repository;

import com.jeterson.winthor.domain.core.entities.RoutineAccessControl;
import com.jeterson.winthor.domain.core.entities.User;

import java.util.Optional;

public interface RoutineAccessControlRepository {

    Optional<RoutineAccessControl> findById(User user, Integer controlCode, Integer routineCode);
}

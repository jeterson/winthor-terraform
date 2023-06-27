package com.jeterson.winthor.domain.application.service.routinecontrolaccess;

import com.jeterson.winthor.domain.application.dto.routinecontrolaccess.CheckPermissionControlAccessRequest;
import com.jeterson.winthor.domain.application.input.service.RoutineAccessControlApplicationService;
import com.jeterson.winthor.domain.application.input.service.SecurityService;
import com.jeterson.winthor.domain.application.output.repository.RoutineAccessControlRepository;
import com.jeterson.winthor.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoutineControlAccessApplicationServiceImpl implements RoutineAccessControlApplicationService {

    private final RoutineAccessControlRepository routineAccessControlRepository;
    private final SecurityService securityService;

    @Override
    public boolean hasAccess(CheckPermissionControlAccessRequest request) {
        var userId = request.getUserId() == null ? securityService.getAuthenticatedUser().getId() : request.getUserId();

        var user = User.builder().id(userId).build();

        var routineControlAccess = routineAccessControlRepository.findById(user, request.getControlCode(), request.getRoutineCode());
        if(routineControlAccess.isEmpty())
            return false;

        return routineControlAccess.get().isAccess();
    }
}

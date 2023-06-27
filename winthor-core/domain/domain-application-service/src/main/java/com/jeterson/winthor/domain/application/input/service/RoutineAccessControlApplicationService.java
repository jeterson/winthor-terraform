package com.jeterson.winthor.domain.application.input.service;

import com.jeterson.winthor.domain.application.dto.routinecontrolaccess.CheckPermissionControlAccessRequest;

public interface RoutineAccessControlApplicationService {

    boolean hasAccess(CheckPermissionControlAccessRequest request);

}

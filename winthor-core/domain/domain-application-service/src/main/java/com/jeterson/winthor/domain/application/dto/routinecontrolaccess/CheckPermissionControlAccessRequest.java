package com.jeterson.winthor.domain.application.dto.routinecontrolaccess;


public interface CheckPermissionControlAccessRequest {
    Integer getControlCode();
    Integer getRoutineCode();
    Integer getUserId();
}

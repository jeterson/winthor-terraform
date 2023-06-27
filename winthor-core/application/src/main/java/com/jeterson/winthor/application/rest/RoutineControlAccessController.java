package com.jeterson.winthor.application.rest;

import com.jeterson.winthor.domain.application.dto.routinecontrolaccess.CheckPermissionControlAccessRequest;
import com.jeterson.winthor.domain.application.dto.routinecontrolaccess.RoutineControlAccessResponse;
import com.jeterson.winthor.domain.application.input.service.RoutineAccessControlApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routine-control-access")
@RequiredArgsConstructor
public class RoutineControlAccessController {

    private final RoutineAccessControlApplicationService routineAccessControlApplicationService;

    @GetMapping
    public ResponseEntity<RoutineControlAccessResponse> hasAccess(CheckPermissionControlAccessRequest request) {
        var access = routineAccessControlApplicationService.hasAccess(request);
        return ResponseEntity.ok(new RoutineControlAccessResponse(access));
    }
}

package com.jeterson.winthor.security.dto.services;

import com.jeterson.winthor.domain.application.input.service.SecurityService;
import com.jeterson.winthor.domain.application.input.service.UserApplicationService;
import com.jeterson.winthor.domain.core.entities.User;
import com.jeterson.winthor.security.dto.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UserApplicationService userApplicationService;

    @Override
    public User getAuthenticatedUser() {
        if(SecurityContextHolder.getContext().getAuthentication() == null)
            throw new RuntimeException("No one user authenticated");

        var username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(username == null)
            throw new RuntimeException("Username not found in authentication");

        return userApplicationService.findByUsername(username);
    }

    @Override
    public boolean isTokenValid(String token) {
        if(token == null || token.isEmpty() || token.isBlank())
            return false;

        return JwtUtils.getInstance().isTokenValid(token);
    }
}

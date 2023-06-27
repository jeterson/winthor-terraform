package com.jeterson.winthor.domain.application.service.user;

import com.jeterson.winthor.domain.application.input.service.UserApplicationService;
import com.jeterson.winthor.domain.application.output.repository.UserRepository;
import com.jeterson.winthor.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("userSecurityApplicationService")
@RequiredArgsConstructor
public class UserSecurityApplicationServiceImpl implements UserApplicationService {

    private final UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        var user = userRepository.findByUsername(username);
        return user.map(value -> User.builder()
                .id(value.getId())
                .name(value.getName())
                .username(value.getUsername().toLowerCase())
                .password(value.getPassword().toLowerCase())
                .build()).orElse(null);

    }
}

package com.jeterson.winthor.domain.application.service.user;

import com.jeterson.winthor.domain.application.input.service.UserApplicationService;
import com.jeterson.winthor.domain.application.output.repository.UserRepository;
import com.jeterson.winthor.domain.core.entities.User;
import com.jeterson.winthor.domain.core.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("userApplicationService")
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserRepository userRepository;

    public User findByUsername(String username) {
        var user = userRepository.findByUsername(username);
        if(user.isEmpty())
            throw new UserNotFoundException(username);

        user.get().removePassword();
        return user.get();

    }
}

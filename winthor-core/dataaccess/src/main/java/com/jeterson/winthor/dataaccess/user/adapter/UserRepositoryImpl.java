package com.jeterson.winthor.dataaccess.user.adapter;

import com.jeterson.winthor.dataaccess.user.mapper.UserDataAccessMapper;
import com.jeterson.winthor.dataaccess.user.repository.UserJpaRepository;
import com.jeterson.winthor.dataaccess.user.repository.WinThorDecryptPasswordRepository;
import com.jeterson.winthor.domain.application.output.repository.UserRepository;
import com.jeterson.winthor.domain.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final WinThorDecryptPasswordRepository winThorDecryptPasswordRepository;
    private final UserDataAccessMapper userDataAccessMapper;

    @Override
    public Optional<User> findByUsername(String username) {
        var user = userJpaRepository.findByUsername(username.toUpperCase()).map(userDataAccessMapper::userEntityToUser);
        if(user.isPresent())
            user.get().setPassword(winThorDecryptPasswordRepository.decryptPassword(user.get().getId()));

        return user;
    }
}

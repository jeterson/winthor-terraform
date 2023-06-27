package com.jeterson.winthor.security.dto.services;

import com.jeterson.winthor.domain.application.input.service.UserApplicationService;
import com.jeterson.winthor.security.dto.UserDetailsData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserApplicationService userSecurityApplicationService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*var user = User.builder()
                .username("PCADMIN")
                .password("PCINF@PCINF")
                .id(1)
                .name("JETERSON MIRANDA GOMES")
                .build();*/
        var user = userSecurityApplicationService.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException("User not found with username " + username);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new UserDetailsData(user);
    }
}

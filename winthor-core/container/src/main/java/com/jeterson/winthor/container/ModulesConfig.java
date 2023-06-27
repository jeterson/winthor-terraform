package com.jeterson.winthor.container;

import com.jeterson.winthor.application.ApplicationModule;
import com.jeterson.winthor.dataaccess.DataAccessModule;
import com.jeterson.winthor.domain.application.service.DomainApplicationServiceModule;
import com.jeterson.winthor.security.dto.SecurityModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ApplicationModule.class,
         DataAccessModule.class,
         SecurityModule.class,
         DomainApplicationServiceModule.class})
public class ModulesConfig {
}

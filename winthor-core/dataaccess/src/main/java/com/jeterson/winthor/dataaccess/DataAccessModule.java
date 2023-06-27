package com.jeterson.winthor.dataaccess;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.jeterson.winthor.dataaccess"})
@EntityScan(basePackages = {"com.jeterson.winthor.dataaccess"})
@ComponentScan(basePackages = "com.jeterson.winthor.dataaccess")
public class DataAccessModule {
}

package com.jeterson.winthor.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"com.thorconsultoria.winthor.sac.application"})
public class ApplicationModule {
}

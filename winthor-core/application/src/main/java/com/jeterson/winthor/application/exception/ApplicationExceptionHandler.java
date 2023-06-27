package com.jeterson.winthor.application.exception;

import com.jeterson.winthor.common.application.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Import({UserApplicationExceptionHandler.class})
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class ApplicationExceptionHandler extends GlobalExceptionHandler {
}
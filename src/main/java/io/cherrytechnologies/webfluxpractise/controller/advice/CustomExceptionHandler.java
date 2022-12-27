package io.cherrytechnologies.webfluxpractise.controller.advice;

import io.cherrytechnologies.webfluxpractise.exception.BadInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BadInputException.class})
    protected Mono<ResponseEntity<Object>> handleConflict(
            RuntimeException ex, ServerWebExchange serverWebExchange) {
        return handleExceptionInternal(ex, ex.getMessage(), null, HttpStatus.BAD_REQUEST, serverWebExchange);
    }
}

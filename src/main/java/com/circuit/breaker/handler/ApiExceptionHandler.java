package com.circuit.breaker.handler;

import com.circuit.breaker.domain.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerMethodException(
            Exception exception,
            HttpServletRequest request
    ) {
        final var error = new ErrorResponse();
        error.setTimestamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.internalServerError().body(error);
    }

}

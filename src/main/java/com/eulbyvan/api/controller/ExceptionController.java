package com.eulbyvan.api.controller;

import com.eulbyvan.model.dto.response.ErrorRes;
import com.eulbyvan.model.exception.RestTemplateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 06/12/2022
 */

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(RestTemplateException.class)
    public ResponseEntity<ErrorRes<String>> handleRestTemplateException(RestTemplateException e) {
        ErrorRes<String> response = new ErrorRes<>(
                "X07", "Rest Template Error", e.getMessage()
        );
        return ResponseEntity.status(e.getStatus()).body(response);
    }
}

package com.youngjong.forum.core.exception.controller;

import com.youngjong.forum.core.exception.ExceptionCodes;
import com.youngjong.forum.core.response.ErrorResponses;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class CustomErrorController implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<ErrorResponses> handleError(HttpServletRequest request) {
        ErrorResponses errorResponse = new ErrorResponses(ExceptionCodes.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));
    }
}

package com.youngjong.forum.core.exception.handler;

import com.youngjong.forum.core.exception.ExceptionCodes;
import com.youngjong.forum.core.exception.GlobalException;
import com.youngjong.forum.core.response.ErrorResponses;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice(basePackages = "com.younjong.forum")
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ErrorResponses handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ErrorResponses.FieldError> errors = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            ErrorResponses.FieldError error = new ErrorResponses.FieldError();
            error.setField(fieldError.getField());
            error.setMessage(fieldError.getDefaultMessage());

            errors.add(error);
        }

        return new ErrorResponses(ExceptionCodes.VALIDATION_FAIL, errors);
    }


    @ExceptionHandler(value = {ConstraintViolationException.class, DataIntegrityViolationException.class})
    protected ErrorResponses handleDataException(Exception e) {
        return new ErrorResponses(ExceptionCodes.DATA_CONFLICT);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ErrorResponses handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new ErrorResponses(ExceptionCodes.BAD_REQUEST);
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ErrorResponses handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return new ErrorResponses(ExceptionCodes.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(AuthenticationException.class)
    protected ErrorResponses handleAuthenticationException(AuthenticationException e) {
        return new ErrorResponses(ExceptionCodes.UNAUTHORIZED);
    }


    @ExceptionHandler(InternalAuthenticationServiceException.class)
    protected ErrorResponses handleInternalAuthenticationServiceException(InternalAuthenticationServiceException e) {
        return new ErrorResponses(ExceptionCodes.USER_NOT_FOUND);
    }


    @ExceptionHandler(AccessDeniedException.class)
    protected ErrorResponses handleAccessDeniedException(AccessDeniedException e) {
        return new ErrorResponses(ExceptionCodes.HANDLE_ACCESS_DENIED);
    }


    @ExceptionHandler(GlobalException.class)
    protected ErrorResponses handleGlobalException(GlobalException e) {
        return new ErrorResponses(e.getExceptionCodes());
    }

    @ExceptionHandler(Exception.class)
    protected ErrorResponses handleException(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return new ErrorResponses(ExceptionCodes.INTERNAL_SERVER_ERROR);
    }


}

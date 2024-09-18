package com.youngjong.forum.core.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.youngjong.forum.core.exception.ExceptionCodes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
public class ErrorResponses {
    private final String message;
    private final int status;
    private final String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FieldError> validation;


    public ErrorResponses(ExceptionCodes codes) {
        this.message = codes.getMessage();
        this.status = codes.getStatus().value();
        this.code = codes.getCode();
    }

    public ErrorResponses(ExceptionCodes codes, String message) {
        this.message = message;
        this.status = codes.getStatus().value();
        this.code = codes.getCode();
    }

    public ErrorResponses(ExceptionCodes codes, List<FieldError> errors) {
        this.message = codes.getMessage();
        this.status = codes.getStatus().value();
        this.code = codes.getCode();
        this.validation = errors;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class FieldError {
        private String field;
        private String message;
    }
}

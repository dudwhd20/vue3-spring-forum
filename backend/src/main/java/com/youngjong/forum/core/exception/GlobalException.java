package com.youngjong.forum.core.exception;

import lombok.Getter;

import java.io.Serial;


@Getter
public class GlobalException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7526472295622776147L;

    private final ExceptionCodes exceptionCodes;

    public GlobalException(ExceptionCodes codes) {
        super(codes.getMessage());
        this.exceptionCodes = codes;
    }

    public GlobalException(ExceptionCodes codes, String message) {
        super(message);
        this.exceptionCodes = codes;
    }

}

package com.youngjong.forum.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ExceptionCodes {
    /* 사용자 요청 예외 */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "U001", "잘못된 요청입니다."),
    VALIDATION_FAIL(HttpStatus.BAD_REQUEST, "U002", "입력된 데이터의 유효성 검증에 실패하였습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U003", "사용자가 존재하지 않습니다."),
    HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "U005", "엑세스 권한이 없습니다."),

    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "R002", "요청하신 HTTP METHOD가 없습니다."),

    /* 토큰 예외 */
    AUTH_TOKEN_INVALID(HttpStatus.UNAUTHORIZED, "T001", "인증토큰이 유효하지 않습니다."),
    AUTH_TOKEN_NOT_MATCH(HttpStatus.UNAUTHORIZED, "T002", "인증토큰이 맞지 않습니다."),
    AUTH_TOKEN_IS_NULL(HttpStatus.UNAUTHORIZED, "T003", "헤더에 인증토큰이 없습니다."),
    NOT_SUPPORTED_JWT_TYPE(HttpStatus.UNAUTHORIZED, "T004", "인증 토큰 타입이 잘못되었습니다"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "T005", "유효한 자격증명이 아닙니다."),

    /* 데이터 예외 */
    DATA_CONFLICT(HttpStatus.CONFLICT, "D001", "중복된 데이터 입니다."),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "D002", "데이터가 없습니다."),
    DATA_INTEGRITY_ERROR(HttpStatus.BAD_REQUEST, "D003", "데이터 무결성 검증에 실패하였습니다."),

    /* 서버 예외 */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "I001", "서버 에러가 발생하였습니다."),

    /* 업무 예외 */
    BUSINESS_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "B001", "업무 예외가 발생하였습니다.");


    private final HttpStatus status;
    private final String code;
    private final String message;

}

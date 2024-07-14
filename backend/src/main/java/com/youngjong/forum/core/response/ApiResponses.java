package com.youngjong.forum.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ApiResponses<T> {

    private HttpStatus status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("message")
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("result")
    private T result;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("error")
    private ErrorResponses error;


    public static <T> ApiResponses<T> success(String message, T data) {
        return ApiResponses.<T>builder()
                .status(HttpStatus.OK)
                .message(message)
                .result(data)
                .build();
    }

    public static <T> ApiResponses<T> success(String message) {
        return ApiResponses.<T>builder()
                .status(HttpStatus.OK)
                .message(message)
                .build();
    }

    public static <T> ApiResponses<T> error(String message, ErrorResponses error) {
        return ApiResponses.<T>builder()
                .status(HttpStatus.valueOf(error.getStatus()))
                .message(message)
                .error(error)
                .build();
    }

}

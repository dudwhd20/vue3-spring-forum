package com.youngjong.forum.core.security.token;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngjong.forum.core.exception.ExceptionCodes;
import com.youngjong.forum.core.response.ApiResponses;
import com.youngjong.forum.core.response.ErrorResponses;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;

    public JwtAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ExceptionCodes exception = (ExceptionCodes) request.getAttribute("exception");

        if (exception.equals(ExceptionCodes.AUTH_TOKEN_IS_NULL)) {
            this.exceptionHandler(response, ExceptionCodes.AUTH_TOKEN_IS_NULL);
            return;
        }

        if (exception.equals(ExceptionCodes.AUTH_TOKEN_INVALID)) {
            this.exceptionHandler(response, ExceptionCodes.AUTH_TOKEN_INVALID);
            return;
        }

        if (exception.equals(ExceptionCodes.DATA_NOT_FOUND)) {
            this.exceptionHandler(response, ExceptionCodes.DATA_NOT_FOUND);

        }

    }

    private void exceptionHandler(HttpServletResponse response, ExceptionCodes exceptionCodes) {
        response.setStatus(exceptionCodes.getStatus().value());
        response.setContentType("application/json");
        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));

        try {
            String json = objectMapper.writeValueAsString(ApiResponses.error("FAIL", new ErrorResponses(exceptionCodes)));
            response.getWriter().write(json);
            log.error("{}", exceptionCodes.getMessage());
        } catch (Exception e) {
            log.error("{}", e.getMessage());
        }
    }
}

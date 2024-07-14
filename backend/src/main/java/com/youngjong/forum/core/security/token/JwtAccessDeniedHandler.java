package com.youngjong.forum.core.security.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngjong.forum.core.exception.ExceptionCodes;
import com.youngjong.forum.core.response.ApiResponses;
import com.youngjong.forum.core.response.ErrorResponses;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Slf4j
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    private final ObjectMapper objectMapper;

    public JwtAccessDeniedHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json");
        response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));

        try {
            String json = objectMapper.writeValueAsString(ApiResponses.error("FAIL", new ErrorResponses(ExceptionCodes.HANDLE_ACCESS_DENIED)));
            response.getWriter().write(json);
        } catch (Exception e) {
            log.error("{}", e.getMessage());
        }
    }
}

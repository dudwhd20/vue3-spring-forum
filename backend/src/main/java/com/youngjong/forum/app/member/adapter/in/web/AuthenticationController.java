package com.youngjong.forum.app.member.adapter.in.web;

import com.youngjong.forum.app.member.application.port.in.AuthenticationCommand;
import com.youngjong.forum.core.security.token.JwtProperties;
import com.youngjong.forum.core.security.token.JwtTokenProvider;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;


    @PostMapping
    public ResponseEntity<Boolean> authentication(@RequestBody AuthenticationCommand authenticationCommand, HttpServletResponse response) {
        UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(authenticationCommand.email(), authenticationCommand.password());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.createAccessToken(authentication);
        String refreshToken = jwtTokenProvider.createRefreshToken(authentication);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(jwtProperties.getHeader(), "Bearer " + jwt);

        Cookie refreshTokenCookie = new Cookie("re", refreshToken);
        refreshTokenCookie.setHttpOnly(true);  // JavaScript 접근 방지
        refreshTokenCookie.setSecure(true);  // HTTPS만 허용
        refreshTokenCookie.setPath("/");  // 쿠키의 유효 경로 설정
        refreshTokenCookie.setMaxAge(jwtProperties.getRefreshTokenExpirationSeconds().intValue());  // 쿠키의 유효 시간 설정 (예: 7일)
        response.addCookie(refreshTokenCookie);

        return new ResponseEntity<>(true, httpHeaders, HttpStatus.OK);
    }
}

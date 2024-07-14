package com.youngjong.forum.core.security.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
@EnableConfigurationProperties(value = JwtProperties.class)
public class JwtTokenProvider {
    private static final String AUTHORITIES_KEY = "Authorization";
    private final JwtProperties jwtProperties;

    public JwtTokenProvider(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public String createAccessToken(Authentication authentication) {
        long now = new Date().getTime();
        Date expriration = new Date(now + jwtProperties.getAccessTokenExpirationSeconds() * 1000);
        return this.createToken(authentication, expriration);
    }

    public String createRefreshToken(Authentication authentication) {
        long now = new Date().getTime();
        Date expriration = new Date(now + jwtProperties.getRefreshTokenExpirationSeconds() * 1000);
        return this.createToken(authentication, expriration);
    }

    public SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String createToken(Authentication authentication, Date expiration) {
        String authority = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .subject(authentication.getName())
                .issuedAt(new Date())
                .claim(AUTHORITIES_KEY, authority)
                .signWith(this.getSignKey())
                .expiration(expiration)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(this.getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .toList();
        User principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(this.getSignKey()).build().parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            log.error("jwt exception");
        } catch (IllegalArgumentException e) {
            log.error("illegal");
        }

        return false;

    }

}

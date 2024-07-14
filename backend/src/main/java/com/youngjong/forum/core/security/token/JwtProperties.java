package com.youngjong.forum.core.security.token;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@ConfigurationProperties(prefix = "jwt.token")
public class JwtProperties {
    private final String header;
    private final String secret;
    private final Long accessTokenExpirationSeconds;
    private final Long refreshTokenExpirationSeconds;

    public JwtProperties(String header, String secret, Long accessTokenExpirationSeconds, Long refreshTokenExpirationSeconds) {
        this.header = header;
        this.secret = secret;
        this.accessTokenExpirationSeconds = accessTokenExpirationSeconds;
        this.refreshTokenExpirationSeconds = refreshTokenExpirationSeconds;
    }
}

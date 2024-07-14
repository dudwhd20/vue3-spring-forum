package com.youngjong.forum.core.security;

import com.youngjong.forum.core.exception.ExceptionCodes;
import com.youngjong.forum.core.exception.GlobalException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


@Slf4j
@UtilityClass
public class SecurityUtil {
    public static Optional<String> getCurrentUserId() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            return Optional.empty();
        }

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return Optional.ofNullable(authentication.getName());
        } else {
            throw new GlobalException(ExceptionCodes.AUTH_TOKEN_IS_NULL);
        }
    }
}


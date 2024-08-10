package com.youngjong.forum.core.config;

import com.youngjong.forum.core.exception.ExceptionCodes;
import com.youngjong.forum.core.exception.GlobalException;
import com.youngjong.forum.core.security.SecurityUtil;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SecurityUtil.getCurrentUserId().orElseThrow(
                () -> new GlobalException(ExceptionCodes.BAD_REQUEST)
        ));
    }
}

package com.youngjong.forum.app.notice.application.in;

import org.springframework.security.core.userdetails.UserDetails;

public interface UpdateNoticeUseCase {
    void update(String id, UpdateNoticeCommand command, UserDetails userDetails);
}

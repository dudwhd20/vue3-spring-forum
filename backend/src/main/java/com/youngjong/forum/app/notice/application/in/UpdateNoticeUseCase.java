package com.youngjong.forum.app.notice.application.in;

public interface UpdateNoticeUseCase {
    void update(String id, UpdateNoticeCommand command);
}

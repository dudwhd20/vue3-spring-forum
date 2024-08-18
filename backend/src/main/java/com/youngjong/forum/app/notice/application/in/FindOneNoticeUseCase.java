package com.youngjong.forum.app.notice.application.in;

import com.youngjong.forum.app.notice.application.out.FindOneNoticeCommand;

public interface FindOneNoticeUseCase {
    FindOneNoticeCommand findOne(Long id);
}

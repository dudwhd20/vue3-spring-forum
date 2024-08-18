package com.youngjong.forum.app.notice.application.out;

import com.youngjong.forum.app.notice.domain.Notice;

public interface FindOneNoticePort {
    Notice findOne(Long id);
}

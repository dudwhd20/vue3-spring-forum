package com.youngjong.forum.app.notice.application.out;

import com.youngjong.forum.app.notice.domain.Notice;

public interface CreateNoticePort {
    void create(Notice notice);
}

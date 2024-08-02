package com.youngjong.forum.app.forum.application.out;

import com.youngjong.forum.app.forum.domain.Notice;

public interface CreateNoticePort {
    void create(Notice notice);
}

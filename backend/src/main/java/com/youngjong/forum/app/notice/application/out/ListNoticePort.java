package com.youngjong.forum.app.notice.application.out;

import com.youngjong.forum.app.notice.domain.Notice;

import java.util.List;

public interface ListNoticePort {
    List<Notice> list();
}

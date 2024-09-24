package com.youngjong.forum.app.notice.application.out;

import com.youngjong.forum.app.notice.domain.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchNoticePort {

    Page<Notice> searchNotice(String title, String author, Pageable pageable);

}

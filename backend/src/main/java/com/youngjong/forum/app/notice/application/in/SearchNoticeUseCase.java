package com.youngjong.forum.app.notice.application.in;

import com.youngjong.forum.app.notice.application.out.FindOneNoticeCommand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchNoticeUseCase {

    Page<FindOneNoticeCommand> searchNotice(String title, String author, Pageable pageable);
}

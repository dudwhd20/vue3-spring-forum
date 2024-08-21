package com.youngjong.forum.app.notice.application.in;

import com.youngjong.forum.app.notice.application.out.FindOneNoticeCommand;

import java.util.List;

public interface ListNoticeUseCase {
    List<FindOneNoticeCommand> list();
}

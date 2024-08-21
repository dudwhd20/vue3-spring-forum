package com.youngjong.forum.app.notice.application.service;

import com.youngjong.forum.app.notice.application.in.UpdateNoticeCommand;
import com.youngjong.forum.app.notice.application.in.UpdateNoticeUseCase;
import com.youngjong.forum.app.notice.application.out.UpdateNoticePort;
import com.youngjong.forum.app.notice.domain.Notice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpdateNoticeService implements UpdateNoticeUseCase {
    private final UpdateNoticePort updateNoticePort;

    public UpdateNoticeService(UpdateNoticePort updateNoticePort) {
        this.updateNoticePort = updateNoticePort;
    }

    @Override
    public void update(String id, UpdateNoticeCommand command) {
        updateNoticePort.update(Notice.builder()
                .id(Long.valueOf(id))
                .title(command.title())
                .content(command.content())
                .build());
    }
}

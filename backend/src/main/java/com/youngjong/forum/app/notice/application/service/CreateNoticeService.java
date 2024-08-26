package com.youngjong.forum.app.notice.application.service;

import com.youngjong.forum.app.notice.application.in.CreateNoticeCommand;
import com.youngjong.forum.app.notice.application.in.CreateNoticeUseCase;
import com.youngjong.forum.app.notice.application.out.CreateNoticePort;
import com.youngjong.forum.app.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateNoticeService implements CreateNoticeUseCase {

    private final CreateNoticePort createNoticePort;

    @Override
    public void createNotice(CreateNoticeCommand command) {
        createNoticePort.create(new Notice().addNotice(command.title(), command.content()));
    }
}

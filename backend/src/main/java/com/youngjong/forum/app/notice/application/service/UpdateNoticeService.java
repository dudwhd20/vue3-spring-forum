package com.youngjong.forum.app.notice.application.service;

import com.youngjong.forum.app.notice.application.in.UpdateNoticeCommand;
import com.youngjong.forum.app.notice.application.in.UpdateNoticeUseCase;
import com.youngjong.forum.app.notice.application.out.FindOneNoticePort;
import com.youngjong.forum.app.notice.application.out.UpdateNoticePort;
import com.youngjong.forum.app.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateNoticeService implements UpdateNoticeUseCase {
    private final UpdateNoticePort updateNoticePort;
    private final FindOneNoticePort findOneNoticePort;


    @Override
    public void update(String id, UpdateNoticeCommand command, UserDetails userDetails) {
        Notice notice = findOneNoticePort.findOne(Long.valueOf(id));
        notice.updateContent(command.title(), command.content(), userDetails.getUsername());
        updateNoticePort.update(notice);
    }
}

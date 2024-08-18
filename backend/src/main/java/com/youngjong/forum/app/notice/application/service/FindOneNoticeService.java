package com.youngjong.forum.app.notice.application.service;

import com.youngjong.forum.app.notice.application.in.FindOneNoticeUseCase;
import com.youngjong.forum.app.notice.application.out.FindOneNoticeCommand;
import com.youngjong.forum.app.notice.application.out.FindOneNoticePort;
import com.youngjong.forum.app.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindOneNoticeService implements FindOneNoticeUseCase{

    private final FindOneNoticePort findOneNoticePort;

    @Override
    public FindOneNoticeCommand findOne(Long id) {
        Notice notice = findOneNoticePort.findOne(id);
        return FindOneNoticeCommand.builder().id(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .viewCount(notice.getViewCount())
                .createBy(notice.getCreateBy())
                .createdAt(notice.getCrateDate().toString())
                .updatedAt(notice.getUpdateDate().toString())
                .build();
    }
}

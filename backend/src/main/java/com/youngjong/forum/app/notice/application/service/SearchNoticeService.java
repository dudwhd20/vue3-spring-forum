package com.youngjong.forum.app.notice.application.service;

import com.youngjong.forum.app.notice.application.in.SearchNoticeUseCase;
import com.youngjong.forum.app.notice.application.out.FindOneNoticeCommand;
import com.youngjong.forum.app.notice.application.out.SearchNoticePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchNoticeService implements SearchNoticeUseCase {

    private final SearchNoticePort searchNoticePort;

    @Override
    public Page<FindOneNoticeCommand> searchNotice(String title, String author, Pageable pageable) {
        return searchNoticePort.searchNotice(title, author, pageable).map(e->
                    FindOneNoticeCommand.builder()
                            .id(e.getId())
                            .title(e.getTitle())
                            .content(e.getContent())
                            .createBy(e.getCreateBy())
                            .createdAt(e.getCrateDate().toString())
                            .updatedAt(e.getUpdateDate().toString())
                            .build()
                );
    }
}

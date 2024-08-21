package com.youngjong.forum.app.notice.application.service;

import com.youngjong.forum.app.notice.application.in.ListNoticeUseCase;
import com.youngjong.forum.app.notice.application.out.FindOneNoticeCommand;
import com.youngjong.forum.app.notice.application.out.ListNoticePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ListNoticeNoticeService implements ListNoticeUseCase {

    private final ListNoticePort listNoticePort;

    public ListNoticeNoticeService(ListNoticePort listNoticePort) {
        this.listNoticePort = listNoticePort;
    }

    @Override
    public List<FindOneNoticeCommand> list() {
        return listNoticePort.list().stream().map(e->
                FindOneNoticeCommand.builder()
                        .id(e.getId()).title(e.getTitle()).content(e.getContent())
                        .createBy(e.getCreateBy()).createdAt(e.getCrateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .updatedAt(e.getUpdateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .viewCount(e.getViewCount())
                        .build()
                ).collect(Collectors.toList());
    }
}

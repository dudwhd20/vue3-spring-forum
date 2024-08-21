package com.youngjong.forum.app.notice.adapter.out.persistence;

import com.youngjong.forum.app.notice.application.out.ListNoticePort;
import com.youngjong.forum.app.notice.domain.Notice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ListNoticeAdapter implements ListNoticePort {
    private final NoticeJPARepository noticeRepository;

    public ListNoticeAdapter(NoticeJPARepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<Notice> list() {
        return noticeRepository.findAll().stream().map(e->
                Notice.builder()
                        .id(e.getId()).title(e.getTitle()).content(e.getContent())
                        .crateDate(e.getCreatedDate())
                        .createBy(e.getCreateBy())
                        .updateDate(e.getUpdateDate())
                        .updateBy(e.getUpdateBy())
                        .viewCount(e.getViewCount())
                        .build()
        ).collect(Collectors.toList());
    }
}

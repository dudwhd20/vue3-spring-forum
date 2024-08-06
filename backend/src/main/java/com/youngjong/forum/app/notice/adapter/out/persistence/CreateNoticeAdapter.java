package com.youngjong.forum.app.notice.adapter.out.persistence;

import com.youngjong.forum.app.notice.application.out.CreateNoticePort;
import com.youngjong.forum.app.notice.application.out.NoticeMapper;
import com.youngjong.forum.app.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class CreateNoticeAdapter implements CreateNoticePort {

    private final NoticeJPARepository noticeJPARepository;

    @Override
    public void create(Notice notice) {
        noticeJPARepository.save(NoticeMapper.toEntity(notice));
    }
}

package com.youngjong.forum.app.notice.adapter.out.persistence;

import com.youngjong.forum.app.notice.application.out.UpdateNoticePort;
import com.youngjong.forum.app.notice.domain.Notice;
import com.youngjong.forum.core.exception.ExceptionCodes;
import com.youngjong.forum.core.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Slf4j
public class UpdateNoticeAdapter implements UpdateNoticePort {
    private final NoticeJPARepository noticeRepository;

    public UpdateNoticeAdapter(NoticeJPARepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public void update(Notice notice) {
        NoticeJPAEntity noticeJPAEntity = noticeRepository.findById(notice.getId())
                .orElseThrow(() -> new GlobalException(ExceptionCodes.BAD_REQUEST, "해당 게시글이 존재하지 않습니다."));
        noticeJPAEntity.update(notice.getTitle(), notice.getContent());
    }
}

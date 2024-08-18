package com.youngjong.forum.app.notice.adapter.out.persistence;

import com.youngjong.forum.app.notice.application.out.DeleteNoticePort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;


@Repository
@Transactional
public class DeleteNoticeAdapter implements DeleteNoticePort {
    private final NoticeJPARepository noticeJPARepository;

    public DeleteNoticeAdapter(NoticeJPARepository noticeJPARepository) {
        this.noticeJPARepository = noticeJPARepository;
    }

    @Override
    public void delete(Long id) {
        var noticeJPAEntity = noticeJPARepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("해당 게시글은 없습니다.")
        );
        noticeJPARepository.delete(noticeJPAEntity);
    }
}

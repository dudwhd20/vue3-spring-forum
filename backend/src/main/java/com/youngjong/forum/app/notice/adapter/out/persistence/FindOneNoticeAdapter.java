package com.youngjong.forum.app.notice.adapter.out.persistence;

import com.youngjong.forum.app.notice.application.out.FindOneNoticePort;
import com.youngjong.forum.app.notice.application.out.NoticeMapper;
import com.youngjong.forum.app.notice.domain.Notice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Repository
@Transactional
public class FindOneNoticeAdapter implements FindOneNoticePort {

    private final NoticeJPARepository noticeJPARepository;

    public FindOneNoticeAdapter(NoticeJPARepository noticeJPARepository) {
        this.noticeJPARepository = noticeJPARepository;
    }

    @Override
    public Notice findOne(Long id) {
        return NoticeMapper.toDomain(noticeJPARepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("해당 게시글이 없습니다.")
        ));
    }
}

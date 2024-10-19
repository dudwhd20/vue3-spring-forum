package com.youngjong.forum.app.notice.adapter.out.persistence;

import com.youngjong.forum.app.notice.application.out.FindOneNoticePort;
import com.youngjong.forum.app.notice.application.out.NoticeMapper;
import com.youngjong.forum.app.notice.domain.Notice;
import com.youngjong.forum.core.security.SecurityUtil;
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

    /**
     * 게시글 상세 보기 시 조회수 증가
     * @param id 게시글 ID
     * @return 게시글 상세 정보
     */
    @Override
    public Notice findOne(Long id) {
        var noticeJPAEntity =  noticeJPARepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("해당 게시글이 없습니다."));
        var currUser = SecurityUtil.getCurrentUserId().orElseThrow(()-> new NoSuchElementException("로그인이 필요합니다."));
        if(!currUser.equals(noticeJPAEntity.getCreateBy())){
            noticeJPAEntity.increaseViewCount();
        }
        return NoticeMapper.toDomain(noticeJPAEntity);
    }
}

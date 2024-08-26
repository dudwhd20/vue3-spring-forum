package com.youngjong.forum.app.comment.adapter.out.persistence;

import com.youngjong.forum.app.comment.application.out.CreateCommentPort;
import com.youngjong.forum.app.comment.domain.Comment;
import com.youngjong.forum.app.notice.adapter.out.persistence.NoticeJPARepository;
import com.youngjong.forum.app.notice.domain.Notice;
import com.youngjong.forum.core.exception.ExceptionCodes;
import com.youngjong.forum.core.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateCommentAdapter implements CreateCommentPort {

    private final NoticeJPARepository noticeJPARepository;
    private final CommentJPARepository commentJPARepository;

    @Override
    public void create(Notice notice, Comment comment) {
        var noticeEntity = noticeJPARepository.findById(notice.getId())
                .orElseThrow(() -> new GlobalException(ExceptionCodes.BAD_REQUEST, "해당 게시글이 존재하지 않습니다."));

        var commentEntity = CommentJPAEntity.builder()
                .notice(noticeEntity)
                .content(comment.getContent())
                .build();

        commentJPARepository.save(commentEntity);
        noticeEntity.addComment(commentEntity);
    }
}

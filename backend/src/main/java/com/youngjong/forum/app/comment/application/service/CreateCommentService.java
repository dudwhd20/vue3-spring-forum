package com.youngjong.forum.app.comment.application.service;

import com.youngjong.forum.app.comment.application.in.CreateCommentCommand;
import com.youngjong.forum.app.comment.application.in.CreateCommentUseCase;
import com.youngjong.forum.app.comment.application.out.CreateCommentPort;
import com.youngjong.forum.app.comment.domain.Comment;
import com.youngjong.forum.app.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCommentService implements CreateCommentUseCase {
    private final CreateCommentPort createCommentPort;

    @Override
    public void create(CreateCommentCommand command) {
        var notice = Notice.builder().id(command.noticeId()).build();
        createCommentPort.create(notice, Comment.builder().content(command.content()).build());
    }
}

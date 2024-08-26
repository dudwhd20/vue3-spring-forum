package com.youngjong.forum.app.comment.application.out;

import com.youngjong.forum.app.comment.domain.Comment;
import com.youngjong.forum.app.notice.domain.Notice;

public interface CreateCommentPort {
    void create(Notice notice, Comment comment);
}

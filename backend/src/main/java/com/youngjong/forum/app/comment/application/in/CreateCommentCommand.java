package com.youngjong.forum.app.comment.application.in;

import lombok.Builder;

@Builder
public record CreateCommentCommand (
    Long noticeId,
    String content
){

}

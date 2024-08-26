package com.youngjong.forum.app.comment.application.in;

public record CreateCommentCommand (
    Long noticeId,
    String content
){

}

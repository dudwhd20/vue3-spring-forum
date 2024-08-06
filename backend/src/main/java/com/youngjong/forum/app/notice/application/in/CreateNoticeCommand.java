package com.youngjong.forum.app.notice.application.in;

import lombok.Builder;

@Builder
public record CreateNoticeCommand(
     String title,
     String content
    )
{}

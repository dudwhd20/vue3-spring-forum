package com.youngjong.forum.app.notice.application.in;

import lombok.Builder;

@Builder
public record UpdateNoticeCommand(
     String title,
     String content
    )
{}

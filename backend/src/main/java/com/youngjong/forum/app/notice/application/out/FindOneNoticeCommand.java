package com.youngjong.forum.app.notice.application.out;

import lombok.Builder;

@Builder
public record FindOneNoticeCommand(
        Long id,
        String title,
        String content,
        Long viewCount,
        String createBy,
        String createdAt,
        String updatedAt
) {
}

package com.youngjong.forum.app.notice.application.out;

import com.youngjong.forum.app.notice.adapter.out.persistence.NoticeJPAEntity;
import com.youngjong.forum.app.notice.application.in.CreateNoticeCommand;
import com.youngjong.forum.app.notice.domain.Notice;

public class NoticeMapper {
    public static Notice toDomain(CreateNoticeCommand command) {
        return new Notice(command.title(), command.content());
    }

    public static NoticeJPAEntity toEntity(Notice notice) {
        return new NoticeJPAEntity(notice.getTitle(), notice.getContent());
    }

}

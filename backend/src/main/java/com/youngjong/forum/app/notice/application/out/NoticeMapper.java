package com.youngjong.forum.app.notice.application.out;

import com.youngjong.forum.app.notice.adapter.out.persistence.NoticeJPAEntity;
import com.youngjong.forum.app.notice.domain.Notice;

public class NoticeMapper {

    public static Notice toDomain(NoticeJPAEntity jpaEntity){
        return Notice.builder()
                .id(jpaEntity.getId())
                .title(jpaEntity.getTitle())
                .content(jpaEntity.getContent())
                .viewCount(jpaEntity.getViewCount())
                .createBy(jpaEntity.getCreateBy())
                .crateDate(jpaEntity.getCreatedDate())
                .updateDate(jpaEntity.getUpdateDate())
                .build();
    }


    public static NoticeJPAEntity toEntity(Notice notice) {
        return new NoticeJPAEntity(notice.getTitle(), notice.getContent());
    }

}

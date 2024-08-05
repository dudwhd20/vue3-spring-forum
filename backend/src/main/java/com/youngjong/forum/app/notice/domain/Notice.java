package com.youngjong.forum.app.notice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class Notice {
    private Integer id;
    private String title;
    private String content;
    private Integer viewCount;
    private String memberId;
    private LocalDateTime crateDate;
    private String createBy;
    private LocalDateTime updateDate;
    private String updateBy;

    @Builder
    public Notice(Integer id, String title, String content, Integer viewCount, String memberId, LocalDateTime crateDate, String createBy, LocalDateTime updateDate, String updateBy) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.memberId = memberId;
        this.crateDate = crateDate;
        this.createBy = createBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
    }
}

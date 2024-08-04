package com.youngjong.forum.app.forum.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class Comment {

    private Long id;
    private String content;
    private LocalDateTime crateDate;
    private String createBy;
    private LocalDateTime updateDate;
    private String updateBy;

    @Builder
    public Comment(Long id, String content, LocalDateTime crateDate, String createBy, LocalDateTime updateDate, String updateBy) {
        this.id = id;
        this.content = content;
        this.crateDate = crateDate;
        this.createBy = createBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
    }
}

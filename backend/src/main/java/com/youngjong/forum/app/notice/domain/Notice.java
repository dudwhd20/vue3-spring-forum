package com.youngjong.forum.app.notice.domain;

import com.youngjong.forum.app.comment.domain.Comment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Notice {
    private Long id;
    private String title;
    private String content;
    private Long viewCount;
    private String memberId;
    private LocalDateTime crateDate;
    private String createBy;
    private LocalDateTime updateDate;
    private String updateBy;

    private List<Comment> comments;



    public Notice addNotice(String title, String content) {
        this.title = title;
        this.content = content;
        return Notice.builder().title(title).content(content).build();
    }






}


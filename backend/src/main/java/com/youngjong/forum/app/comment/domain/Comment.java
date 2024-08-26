package com.youngjong.forum.app.comment.domain;

import com.youngjong.forum.app.notice.domain.Notice;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Comment {

    private Long id;
    private String content;
    private LocalDateTime crateDate;
    private String createBy;
    private LocalDateTime updateDate;
    private String updateBy;

    private Notice notice;


}

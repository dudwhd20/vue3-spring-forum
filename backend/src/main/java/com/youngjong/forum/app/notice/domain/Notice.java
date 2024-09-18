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



    public void updateContent(String newTitle, String newContent, String updatedBy) {
        if (newTitle == null || newTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("제목은 빈 값일 수 없습니다.");
        }
        if (newContent == null || newContent.trim().isEmpty()) {
            throw new IllegalArgumentException("내용은 빈 값일 수 없습니다.");
        }
        validateCreator(updatedBy);
        this.title = newTitle;
        this.content = newContent;
        this.updateDate = LocalDateTime.now();
        this.updateBy = updatedBy;
    }

    // Validate creator
    public void validateCreator(String creator) {
        if (!this.createBy.equals(creator)) {
            throw new IllegalArgumentException("작성자만 수정할 수 있습니다.");
        }
    }


}


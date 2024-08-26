package com.youngjong.forum.app.comment.adapter.out.persistence;

import com.youngjong.forum.app.notice.adapter.out.persistence.NoticeJPAEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "COMMENT")
@SequenceGenerator(
        name = "COMMENT_SEQ_GENERATOR",
        sequenceName = "comment_seq",
        allocationSize = 1
)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentJPAEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SEQ_GENERATOR")
    private Long id;

    @NotNull
    @Lob
    @Column(name = "CONTENT", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private NoticeJPAEntity notice;


}

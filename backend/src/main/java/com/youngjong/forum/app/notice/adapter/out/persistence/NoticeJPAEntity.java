package com.youngjong.forum.app.notice.adapter.out.persistence;

import com.youngjong.forum.app.comment.adapter.out.persistence.CommentJPAEntity;
import com.youngjong.forum.core.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "NOTICE")
@SequenceGenerator(
        name = "NOTICE_SEQ_GENERATOR",
        sequenceName = "notice_seq",
        allocationSize = 1
)
@NoArgsConstructor
public class NoticeJPAEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTICE_SEQ_GENERATOR")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "TITLE", nullable = false)
    private String title;

    @NotNull
    @Lob
    @Column(name = "CONTENT", nullable = false)
    private String content;


    @ColumnDefault("0")
    @Column(name = "VIEW_COUNT")
    private Long viewCount;

    @OneToMany(mappedBy = "notice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentJPAEntity> comments = new ArrayList<>();


    public NoticeJPAEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public NoticeJPAEntity(Long id){
        this.id = id;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void addComment(CommentJPAEntity comment) {
        comments.add(comment);
        comment.setNotice(this);
    }

    public void increaseViewCount() {
        this.viewCount++;
    }


}

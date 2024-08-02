package com.youngjong.forum.app.forum.adapter.out.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "NOTICE")
@SequenceGenerator(
        name = "NOTICE_SEQ_GENERATOR",
        sequenceName = "notice_seq",
        allocationSize = 1
)
public class NoticeJPAEntity {
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

    @NotNull
    @Column(name = "POST_DATE", nullable = false)
    private Instant postDate;

    @ColumnDefault("0")
    @Column(name = "VIEW_COUNT")
    private Long viewCount;

    @NotNull
    @Column(name = "CRATE_DATE", nullable = false)
    private Instant crateDate;

    @Size(max = 255)
    @NotNull
    @Column(name = "CREATE_BY", nullable = false)
    private String createBy;

    @NotNull
    @Column(name = "UPDATE_DATE", nullable = false)
    private Instant updateDate;

    @Size(max = 255)
    @NotNull
    @Column(name = "UPDATE_BY", nullable = false)
    private String updateBy;

}

package com.youngjong.forum.app.heart.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Builder
@ToString
public class Heart {
    private Long id;
    private Long memberId;
    private Long commentId;
    private LocalDateTime createDate;
    private String createBy;
    private LocalDateTime updateDate;
    private String updateBy;

    // 하트 추가
    public Heart addHeart(Long memberId, Long commentId) {
        this.memberId = memberId;
        this.commentId = commentId;
        return Heart.builder().memberId(memberId).commentId(commentId).build();
    }



}

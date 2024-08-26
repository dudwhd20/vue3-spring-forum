package com.youngjong.forum.app.comment.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJPARepository extends JpaRepository<CommentJPAEntity, Long> {
}

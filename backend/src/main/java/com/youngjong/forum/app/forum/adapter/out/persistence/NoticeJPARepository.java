package com.youngjong.forum.app.forum.adapter.out.persistence;

import com.youngjong.forum.app.forum.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeJPARepository extends JpaRepository<Notice, Long> {
}

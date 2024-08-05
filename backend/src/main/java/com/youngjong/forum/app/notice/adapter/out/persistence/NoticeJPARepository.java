package com.youngjong.forum.app.notice.adapter.out.persistence;

import com.youngjong.forum.app.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeJPARepository extends JpaRepository<Notice, Long> {
}

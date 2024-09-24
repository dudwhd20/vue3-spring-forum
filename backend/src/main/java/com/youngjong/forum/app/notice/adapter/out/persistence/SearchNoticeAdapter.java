package com.youngjong.forum.app.notice.adapter.out.persistence;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.youngjong.forum.app.notice.application.out.NoticeMapper;
import com.youngjong.forum.app.notice.application.out.SearchNoticePort;
import com.youngjong.forum.app.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.youngjong.forum.app.notice.adapter.out.persistence.QNoticeJPAEntity.noticeJPAEntity;

@Repository
@RequiredArgsConstructor
public class SearchNoticeAdapter implements SearchNoticePort {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Notice> searchNotice(String title, String author, Pageable pageable) {
        List<NoticeJPAEntity> results = queryFactory
                .selectFrom(noticeJPAEntity)
                .where(
                        containsTitle(title),
                        containsAuthor(author)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .selectFrom(noticeJPAEntity)
                .where(
                        containsTitle(title),
                        containsAuthor(author)
                )
                .fetch().size();

        return new PageImpl<>(results, pageable, total).map(NoticeMapper::toDomain);
    }

    private BooleanExpression containsTitle(String title) {
        return title != null ? noticeJPAEntity.title.contains(title) : null;
    }

    private BooleanExpression containsAuthor(String author) {
        return author != null ? noticeJPAEntity.createBy.contains(author) : null;
    }
}

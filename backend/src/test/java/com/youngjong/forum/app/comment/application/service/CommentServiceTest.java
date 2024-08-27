package com.youngjong.forum.app.comment.application.service;

import com.youngjong.forum.app.comment.application.in.CreateCommentCommand;
import com.youngjong.forum.app.comment.application.in.CreateCommentUseCase;
import com.youngjong.forum.app.member.adapter.in.security.MyUserDetailService;
import com.youngjong.forum.app.notice.adapter.out.persistence.NoticeJPARepository;
import com.youngjong.forum.app.notice.application.out.NoticeMapper;
import com.youngjong.forum.app.notice.domain.Notice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class CommentServiceTest {

    @Autowired
    NoticeJPARepository noticeJPARepository;
    @Autowired
    CreateCommentUseCase createCommentUseCase;
    @Autowired
    MyUserDetailService customUserDetailsService;

    @BeforeEach
    public void setUp(){
        UserDetails user = customUserDetailsService.loadUserByUsername("test@test.com");
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(user, "test", user.getAuthorities()));
    }

    @Test
    public void create(){
        var noticeJPAEntity =  noticeJPARepository.save(NoticeMapper.toEntity(Notice.builder().title("test").content("test").build()) );
        var command = CreateCommentCommand.builder().noticeId(noticeJPAEntity.getId()).content("content").build();
        createCommentUseCase.create(command);
    }

}

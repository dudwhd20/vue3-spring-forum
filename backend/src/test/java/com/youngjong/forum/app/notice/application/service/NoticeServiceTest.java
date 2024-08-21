package com.youngjong.forum.app.notice.application.service;

import com.youngjong.forum.app.member.adapter.in.security.MyUserDetailService;
import com.youngjong.forum.app.notice.adapter.out.persistence.NoticeJPAEntity;
import com.youngjong.forum.app.notice.adapter.out.persistence.NoticeJPARepository;
import com.youngjong.forum.app.notice.application.in.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class NoticeServiceTest {

    @Autowired
    CreateNoticeService createNoticeService;
    @Autowired
    MyUserDetailService customUserDetailsService;
    @Autowired
    FindOneNoticeUseCase findOneNoticeUseCase;
    @Autowired
    NoticeJPARepository noticeJPARepository;
    @Autowired
    DeleteNoticeUseCase deleteNoticeUseCase;

    @Autowired
    ListNoticeUseCase listNoticeUseCase;

    @Autowired
    UpdateNoticeService updateNoticeService;

    @BeforeEach
    public void setUp(){
        UserDetails user = customUserDetailsService.loadUserByUsername("test@test.com");
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(user, "test", user.getAuthorities()));
    }

    @Test
    @DisplayName("게시글 생성")
    public void create(){
        var command = CreateNoticeCommand.builder().title("title").content("content").build();
        createNoticeService.createNotice(command);
    }

    @Test
    @DisplayName("게시글 단건 조회")
    public void findOne(){
        var r = findOneNoticeUseCase.findOne(257L);
        assertThat(r).isNotNull();
        assertThat(r.id()).isEqualTo(257L);
    }

    @Test
    @DisplayName("게시글 삭제")
    public void delete(){
        var delData = noticeJPARepository.save(new NoticeJPAEntity("title", "content"));
        long targetId = delData.getId();

        deleteNoticeUseCase.deleteNotice(targetId);
    }

    @Test
    @DisplayName("게시글 전체 조회")
    public void list(){
        var r = listNoticeUseCase.list();
        assertThat(r).isNotNull();
    }

    @Test
    @DisplayName("게시글 수정")
    public void update(){
        var delData = noticeJPARepository.save(new NoticeJPAEntity("title", "content"));
        updateNoticeService.update(String.valueOf(delData.getId()), UpdateNoticeCommand.builder().title("test").content("test").build());

        var r = findOneNoticeUseCase.findOne(delData.getId());
        assertThat(r).isNotNull();
        assertThat(r.title()).isEqualTo("test");
        assertThat(r.content()).isEqualTo("test");
    }
}

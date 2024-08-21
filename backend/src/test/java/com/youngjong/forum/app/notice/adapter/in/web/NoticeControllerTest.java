package com.youngjong.forum.app.notice.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngjong.forum.app.member.adapter.in.security.MyUserDetailService;
import com.youngjong.forum.app.notice.adapter.out.persistence.NoticeJPAEntity;
import com.youngjong.forum.app.notice.adapter.out.persistence.NoticeJPARepository;
import com.youngjong.forum.app.notice.application.in.CreateNoticeCommand;
import com.youngjong.forum.app.notice.application.in.UpdateNoticeCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class NoticeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    NoticeJPARepository noticeJPARepository;

    @Autowired
    MyUserDetailService customUserDetailsService;

    @BeforeEach
    public void setUp(){
        UserDetails user = customUserDetailsService.loadUserByUsername("test@test.com");
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(user, "test", user.getAuthorities()));
    }

    @Test
    @DisplayName("게시글 생성")
    void create() throws Exception {
        var dto = CreateNoticeCommand.builder().title("title").content("content").build();
        var contentJson = new ObjectMapper().writeValueAsString(dto);

        //when
        mockMvc.perform(post("/api/notice")
                .content(contentJson)
                .contentType("application/json"))
                //then
                .andExpect(status().isOk())
        ;
    }

    @Test
    @DisplayName("게시글 생성")
    void findOne() throws Exception {
        long id = 257L;

        //when
        mockMvc.perform(get("/api/notice/" + id)
                .contentType("application/json"))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result.id").value(id))
        ;
    }

    @Test
    @DisplayName("게시글 삭제")
    void delete() throws Exception {
        var delData = noticeJPARepository.save(new NoticeJPAEntity("title", "content"));
        long targetId = delData.getId();

        //when
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/notice/" + targetId)
                .contentType("application/json"))
                //then
                .andExpect(status().isOk())
        ;
    }

    @Test
    @DisplayName("게시글 전체 조회")
    void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/notice" )
                .contentType("application/json"))
                //then
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    @DisplayName("게시글 수정")
    void update() throws Exception {

        var delData = noticeJPARepository.save(new NoticeJPAEntity("title", "content"));


        mockMvc.perform(MockMvcRequestBuilders.put("/api/notice/" + delData.getId())
                .content(
                        new ObjectMapper().writeValueAsString(UpdateNoticeCommand.builder().title("test").content("test").build())
                )
                .contentType("application/json"))
                //then
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("SUCCESS"))
        ;
    }


}

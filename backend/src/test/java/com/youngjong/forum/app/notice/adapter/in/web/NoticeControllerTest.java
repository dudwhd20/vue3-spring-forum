package com.youngjong.forum.app.notice.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngjong.forum.app.member.adapter.in.security.MyUserDetailService;
import com.youngjong.forum.app.notice.application.in.CreateNoticeCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class NoticeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MyUserDetailService customUserDetailsService;

    @BeforeEach
    public void setUp(){
        UserDetails user = customUserDetailsService.loadUserByUsername("test@test.com");
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(user, "test", user.getAuthorities()));
    }

    @Test
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
}

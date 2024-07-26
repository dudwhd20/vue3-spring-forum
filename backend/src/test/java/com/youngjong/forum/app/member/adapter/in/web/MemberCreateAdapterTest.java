package com.youngjong.forum.app.member.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngjong.forum.app.member.application.port.in.MemberCreateCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class MemberCreateAdapterTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void create() throws Exception {
        var req = MemberCreateCommand.builder().email("test3@test.com")
                .password("test").name("test").build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/member")
                .content(new ObjectMapper().writeValueAsBytes(req))
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andReturn();
    }

}

package com.youngjong.forum.app.member.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngjong.forum.app.member.application.port.in.AuthenticationCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void authenticate() throws Exception {
            var req = AuthenticationCommand.builder().email("test@test.com")
            .password("test").build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth")
                .content(new ObjectMapper().writeValueAsBytes(req))
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$.result").exists())
        .andExpect(jsonPath("$.result").isBoolean())
        .andExpect(jsonPath("$.result").value(true))
        .andReturn();
    }

}

package com.youngjong.forum.app.member.adapter.in.web;

import com.youngjong.forum.app.member.application.port.in.MemberCreateCommand;
import com.youngjong.forum.app.member.application.port.in.MemberUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
class MemberServiceTest {
    @Autowired
    MemberUseCase memberUseCase;

    @Test
    @Transactional
    void create() {
        var v = MemberCreateCommand.builder().email("test@test.com")
                .name("test")
                .password("test").build();

        memberUseCase.addMember(v.email(), v.name(), v.password());



    }
}

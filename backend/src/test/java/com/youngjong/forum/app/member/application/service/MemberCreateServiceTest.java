package com.youngjong.forum.app.member.application.service;

import com.youngjong.forum.app.member.application.port.in.CreateMemberUseCase;
import com.youngjong.forum.app.member.application.port.in.MemberCreateCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberCreateServiceTest {
    @Autowired
    CreateMemberUseCase memberUseCase;

    @Test
    @Transactional
    void create() {
        var v = MemberCreateCommand.builder().email("test@test.com")
                .name("test")
                .password("test").build();

        memberUseCase.addMember(v.email(), v.name(), v.password());



    }
}

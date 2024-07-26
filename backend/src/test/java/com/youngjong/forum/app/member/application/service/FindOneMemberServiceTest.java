package com.youngjong.forum.app.member.application.service;

import com.youngjong.forum.app.member.application.port.in.CreateMemberUseCase;
import com.youngjong.forum.app.member.application.port.in.FindOneMemberUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FindOneMemberServiceTest {
    @Autowired
    FindOneMemberUseCase findOneMemberUseCase;

    @Autowired
    CreateMemberUseCase createMemberUseCase;


    @Test
    @Transactional
    public void findOneMemberByEmail() {
        createMemberUseCase.addMember("test2@test.com", "test", "test");

        var v = findOneMemberUseCase.findOneMemberByEmail("test@test.com");

        assertThat(v.orElse(null)).isNotNull();
        assertThat(Objects.requireNonNull(v.orElse(null)).getEmail()).isEqualTo("test@test.com");
        assertThat(Objects.requireNonNull(v.orElse(null)).getName()).isEqualTo("test");

    }



}

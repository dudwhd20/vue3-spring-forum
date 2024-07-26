package com.youngjong.forum.app.member.application.port.in;

import com.youngjong.forum.app.member.domain.Member;

import java.util.Optional;

public interface FindOneMemberUseCase {
    Optional<Member> findOneMemberByEmail(String email);
}

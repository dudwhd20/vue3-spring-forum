package com.youngjong.forum.app.member.application.port.out;

import com.youngjong.forum.app.member.domain.Member;

import java.util.Optional;

public interface FindOneMemberPort {
    Optional<Member> findOneMemberByEmail(String email);
}

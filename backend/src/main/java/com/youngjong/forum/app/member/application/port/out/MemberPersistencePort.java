package com.youngjong.forum.app.member.application.port.out;

import com.youngjong.forum.app.member.domain.Member;

public interface MemberPersistencePort {
    void create(Member member);
}

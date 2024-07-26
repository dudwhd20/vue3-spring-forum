package com.youngjong.forum.app.member.application.port.out;

import com.youngjong.forum.app.member.domain.Member;

public interface MemberCratePort {
    void create(Member member);
}

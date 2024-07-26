package com.youngjong.forum.app.member.application.service;

import com.youngjong.forum.app.member.application.port.in.FindOneMemberUseCase;
import com.youngjong.forum.app.member.application.port.out.FindOneMemberPort;
import com.youngjong.forum.app.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindOneMemberService implements FindOneMemberUseCase {

    private final FindOneMemberPort findOneMemberPort;

    @Override
    public Optional<Member> findOneMemberByEmail(String email) {
        return findOneMemberPort.findOneMemberByEmail(email);
    }
}

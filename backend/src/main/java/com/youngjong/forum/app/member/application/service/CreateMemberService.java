package com.youngjong.forum.app.member.application.service;

import com.youngjong.forum.app.member.application.port.in.CreateMemberUseCase;
import com.youngjong.forum.app.member.application.port.out.MemberCratePort;
import com.youngjong.forum.app.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMemberService implements CreateMemberUseCase {

    private final MemberCratePort memberCratePort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addMember(String email, String name, String password) {
        memberCratePort.create(Member.builder().email(email).name(name).password(
                passwordEncoder.encode(password)
        ).build());
    }


}

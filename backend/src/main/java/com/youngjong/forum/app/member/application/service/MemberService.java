package com.youngjong.forum.app.member.application.service;

import com.youngjong.forum.app.member.application.port.in.MemberUseCase;
import com.youngjong.forum.app.member.application.port.out.MemberPersistencePort;
import com.youngjong.forum.app.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {

    private final MemberPersistencePort memberPersistencePort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addMember(String email, String name, String password) {
        memberPersistencePort.create(Member.builder().email(email).name(name).password(
                passwordEncoder.encode(password)
        ).build());
    }


}

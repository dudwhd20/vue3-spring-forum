package com.youngjong.forum.app.member.adapter.out.persistence;

import com.youngjong.forum.app.member.application.port.out.FindOneMemberPort;
import com.youngjong.forum.app.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class FindOneMemberAdapter implements FindOneMemberPort {

    private final MemberJPARepository memberJPARepository;


    @Override
    public Optional<Member> findOneMemberByEmail(String email) {
        return memberJPARepository.findByEmail(email).map(MemberMapper::toDomain);
    }
}

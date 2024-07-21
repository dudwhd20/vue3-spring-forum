package com.youngjong.forum.app.member.adapter.out.persistence;

import com.youngjong.forum.app.member.application.port.out.MemberPersistencePort;
import com.youngjong.forum.app.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class MemberRepository implements MemberPersistencePort {

    private final MemberJPARepository memberJPARepository;


    @Override
    public void create(Member member) {
        memberJPARepository.save(
                MemberMapper.toEntity(member.getId(), member.getEmail(),member.getName(),member.getPassword())
        );

    }
}

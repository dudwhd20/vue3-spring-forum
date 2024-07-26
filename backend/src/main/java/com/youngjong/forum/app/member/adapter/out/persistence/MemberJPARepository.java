package com.youngjong.forum.app.member.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJPARepository extends JpaRepository<MemberJPAEntity, Integer> {
    Optional<MemberJPAEntity> findByEmail(String email);
}

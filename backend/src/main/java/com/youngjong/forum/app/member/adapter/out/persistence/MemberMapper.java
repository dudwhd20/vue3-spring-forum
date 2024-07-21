package com.youngjong.forum.app.member.adapter.out.persistence;

import com.youngjong.forum.app.member.domain.Member;

public class MemberMapper {

    public static MemberJPAEntity toEntity(Integer id, String email, String name, String password) {
        return new MemberJPAEntity(id, email, name, password);
    }

    public static Member toDomain(MemberJPAEntity memberJPAEntity) {
        return new Member(memberJPAEntity.getId(), memberJPAEntity.getEmail(), memberJPAEntity.getName(), memberJPAEntity.getPassword());
    }
}

package com.youngjong.forum.app.member.adapter.out.persistence;

import com.youngjong.forum.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "member")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "member_seq",
        allocationSize = 1
)
public class MemberJPAEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    private Integer id;

    @Column(unique = true)
    private String email;

    @Column(name = "username")
    private String name;

    private String password;

    public MemberJPAEntity(Integer id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }


    protected MemberJPAEntity() {

    }
}

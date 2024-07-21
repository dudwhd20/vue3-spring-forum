package com.youngjong.forum.app.member.domain;


import io.jsonwebtoken.lang.Assert;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Member {
    private Integer id;
    private String email;
    private String name;
    private String password;

    @Builder
    public Member(Integer id, String email, String name, String password) {
        Assert.notNull(email, "email must not be null");
        Assert.notNull(password, "password must not be null");
        Assert.notNull(name, "name must not be null");
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

}

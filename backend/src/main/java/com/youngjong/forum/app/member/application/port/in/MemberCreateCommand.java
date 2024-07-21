package com.youngjong.forum.app.member.application.port.in;

import lombok.Builder;

@Builder
public record MemberCreateCommand (
    String email,
    String name,
    String password
){

}

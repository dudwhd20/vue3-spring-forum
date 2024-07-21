package com.youngjong.forum.app.member.application.port.in;

public interface MemberUseCase {

    void addMember(String email, String name, String password);

}

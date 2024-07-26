package com.youngjong.forum.app.member.adapter.in.security;

import com.youngjong.forum.app.member.adapter.out.security.MyUserDetails;
import com.youngjong.forum.app.member.application.port.in.FindOneMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private final FindOneMemberUseCase findOneMemberUseCase;

    @Override
    public MyUserDetails loadUserByUsername(String username) {
        return findOneMemberUseCase.findOneMemberByEmail(username)
                .map(MyUserDetails::new)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

}

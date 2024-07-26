package com.youngjong.forum.app.member.application.port.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record AuthenticationCommand (
        @Email
        @NotNull
        String email,
        @NotNull
        String password
){

}

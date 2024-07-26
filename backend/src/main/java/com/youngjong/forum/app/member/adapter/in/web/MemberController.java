package com.youngjong.forum.app.member.adapter.in.web;

import com.youngjong.forum.app.member.application.port.in.CreateMemberUseCase;
import com.youngjong.forum.app.member.application.port.in.MemberCreateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final CreateMemberUseCase memberUseCase;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MemberCreateCommand createCommand) {
        memberUseCase.addMember(createCommand.email(), createCommand.email(), createCommand.password());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

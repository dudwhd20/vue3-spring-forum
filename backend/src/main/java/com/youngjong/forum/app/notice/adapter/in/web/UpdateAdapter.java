package com.youngjong.forum.app.notice.adapter.in.web;

import com.youngjong.forum.app.notice.application.in.UpdateNoticeCommand;
import com.youngjong.forum.app.notice.application.in.UpdateNoticeUseCase;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notice")
public class UpdateAdapter {
    private final UpdateNoticeUseCase updateNoticeUseCase;

    public UpdateAdapter(UpdateNoticeUseCase updateNoticeUseCase) {
        this.updateNoticeUseCase = updateNoticeUseCase;
    }


    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody UpdateNoticeCommand updateNoticeCommand, @AuthenticationPrincipal UserDetails userDetails) {
        updateNoticeUseCase.update(id, updateNoticeCommand, userDetails);
    }
}

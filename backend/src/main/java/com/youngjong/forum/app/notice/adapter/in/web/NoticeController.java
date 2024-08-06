package com.youngjong.forum.app.notice.adapter.in.web;

import com.youngjong.forum.app.notice.application.in.CreateNoticeCommand;
import com.youngjong.forum.app.notice.application.in.CreateNoticeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final CreateNoticeUseCase createNoticeUseCase;

    @PostMapping
    public void create(@RequestBody CreateNoticeCommand createNoticeCommand) {
        createNoticeUseCase.createNotice(createNoticeCommand);
    }


}

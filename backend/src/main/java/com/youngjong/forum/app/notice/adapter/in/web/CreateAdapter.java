package com.youngjong.forum.app.notice.adapter.in.web;

import com.youngjong.forum.app.notice.application.in.CreateNoticeCommand;
import com.youngjong.forum.app.notice.application.in.CreateNoticeUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notice")
public class CreateAdapter {
    private final CreateNoticeUseCase createNoticeUseCase;

    public CreateAdapter(CreateNoticeUseCase createNoticeUseCase) {
        this.createNoticeUseCase = createNoticeUseCase;
    }

    @PostMapping
    public void create(@RequestBody CreateNoticeCommand createNoticeCommand) {
        createNoticeUseCase.createNotice(createNoticeCommand);
    }
}

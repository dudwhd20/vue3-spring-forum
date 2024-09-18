package com.youngjong.forum.app.notice.adapter.in.web;

import com.youngjong.forum.app.notice.application.in.ListNoticeUseCase;
import com.youngjong.forum.app.notice.application.out.FindOneNoticeCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notice")
public class AllListAdapter {
    private final ListNoticeUseCase listNoticeUseCase;

    public AllListAdapter(ListNoticeUseCase listNoticeUseCase) {
        this.listNoticeUseCase = listNoticeUseCase;
    }

    @GetMapping
    public List<FindOneNoticeCommand> list() {
        return listNoticeUseCase.list();
    }
}

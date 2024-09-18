package com.youngjong.forum.app.notice.adapter.in.web;

import com.youngjong.forum.app.notice.application.in.FindOneNoticeUseCase;
import com.youngjong.forum.app.notice.application.out.FindOneNoticeCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/notice")
public class FindOneAdapter {

    private final FindOneNoticeUseCase findOneNoticeUseCase;

    public FindOneAdapter(FindOneNoticeUseCase findOneNoticeUseCase) {
        this.findOneNoticeUseCase = findOneNoticeUseCase;
    }


    @GetMapping("/{id}")
    public FindOneNoticeCommand findOne(@PathVariable Long id) {
        return findOneNoticeUseCase.findOne(id);
    }
}

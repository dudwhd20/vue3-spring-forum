package com.youngjong.forum.app.notice.adapter.in.web;

import com.youngjong.forum.app.notice.application.in.CreateNoticeCommand;
import com.youngjong.forum.app.notice.application.in.CreateNoticeUseCase;
import com.youngjong.forum.app.notice.application.in.DeleteNoticeUseCase;
import com.youngjong.forum.app.notice.application.in.FindOneNoticeUseCase;
import com.youngjong.forum.app.notice.application.out.FindOneNoticeCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final CreateNoticeUseCase createNoticeUseCase;
    private final DeleteNoticeUseCase deleteNoticeUseCase;
    private final FindOneNoticeUseCase findOneNoticeUseCase;

    @GetMapping("/{id}")
    public FindOneNoticeCommand findOne(@PathVariable Long id) {
        return findOneNoticeUseCase.findOne(id);
    }

    @PostMapping
    public void create(@RequestBody CreateNoticeCommand createNoticeCommand) {
        createNoticeUseCase.createNotice(createNoticeCommand);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id ) {
        deleteNoticeUseCase.deleteNotice(id);
    }


}

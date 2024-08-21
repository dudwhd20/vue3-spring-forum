package com.youngjong.forum.app.notice.adapter.in.web;

import com.youngjong.forum.app.notice.application.in.*;
import com.youngjong.forum.app.notice.application.out.FindOneNoticeCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final CreateNoticeUseCase createNoticeUseCase;
    private final DeleteNoticeUseCase deleteNoticeUseCase;
    private final FindOneNoticeUseCase findOneNoticeUseCase;
    private final ListNoticeUseCase listNoticeUseCase;
    private final UpdateNoticeUseCase updateNoticeUseCase;

    @GetMapping("/{id}")
    public FindOneNoticeCommand findOne(@PathVariable Long id) {
        return findOneNoticeUseCase.findOne(id);
    }

    @GetMapping
    public List<FindOneNoticeCommand> list() {
        return listNoticeUseCase.list();
    }

    @PostMapping
    public void create(@RequestBody CreateNoticeCommand createNoticeCommand) {
        createNoticeUseCase.createNotice(createNoticeCommand);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id , @RequestBody UpdateNoticeCommand updateNoticeCommand) {
        updateNoticeUseCase.update(id, updateNoticeCommand);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id ) {
        deleteNoticeUseCase.deleteNotice(id);
    }


}

package com.youngjong.forum.app.notice.adapter.in.web;

import com.youngjong.forum.app.notice.application.in.DeleteNoticeUseCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notice")
public class DeleteAdapter {
    private final DeleteNoticeUseCase deleteNoticeUseCase;

    public DeleteAdapter(DeleteNoticeUseCase deleteNoticeUseCase) {
        this.deleteNoticeUseCase = deleteNoticeUseCase;
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id ) {
        deleteNoticeUseCase.deleteNotice(id);
    }
}

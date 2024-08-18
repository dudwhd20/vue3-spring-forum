package com.youngjong.forum.app.notice.application.service;

import com.youngjong.forum.app.notice.application.in.DeleteNoticeUseCase;
import com.youngjong.forum.app.notice.application.out.DeleteNoticePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeleteNoticeService implements DeleteNoticeUseCase {

    private final DeleteNoticePort deleteNoticePort;

    public DeleteNoticeService(DeleteNoticePort deleteNoticePort) {
        this.deleteNoticePort = deleteNoticePort;
    }

    @Override
    public void deleteNotice(Long id) {
        deleteNoticePort.delete(id);
    }
}

package com.youngjong.forum.app.notice.adapter.in.web;

import com.youngjong.forum.app.notice.application.in.SearchNoticeUseCase;
import com.youngjong.forum.app.notice.application.out.FindOneNoticeCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notices")
@RequiredArgsConstructor
public class SearchPagingAdapter {

    private final SearchNoticeUseCase searchNoticeUseCase;

    @GetMapping("/search")
    public Page<FindOneNoticeCommand> searchNotice(
                        @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            Pageable pageable
    ){
        return searchNoticeUseCase.searchNotice(title, author, pageable);
    }

}

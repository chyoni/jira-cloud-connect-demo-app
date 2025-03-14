package kr.osci.addons.app.domain.board.controller.api;

import com.atlassian.connect.spring.AtlassianHostUser;
import kr.osci.addons.app.domain.board.service.ArticleService;
import kr.osci.addons.app.domain.board.service.request.ArticleCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardApiController {

    private final ArticleService articleService;

    @PostMapping
    public String create(@AuthenticationPrincipal AtlassianHostUser hostUser,
                         @RequestBody ArticleCreateRequest request) {
        log.info("[create:25] hostUser: {}", hostUser.getUserAccountId());
        log.info("[create:25] request: {}", request);
        return "OK";
    }
}

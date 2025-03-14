package kr.osci.addons.app.domain.board.controller.api;

import com.atlassian.connect.spring.AtlassianHostUser;
import com.atlassian.connect.spring.IgnoreJwt;
import kr.osci.addons.app.domain.board.controller.api.response.ApiResponse;
import kr.osci.addons.app.domain.board.service.ArticleService;
import kr.osci.addons.app.domain.board.service.request.ArticleCreateRequest;
import kr.osci.addons.app.domain.board.service.response.ArticleCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@IgnoreJwt
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardApiController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ApiResponse<ArticleCreateResponse>> create(@AuthenticationPrincipal AtlassianHostUser hostUser,
                                                                     @RequestBody ArticleCreateRequest request) {
        log.info("[create:30] ArticleCreateRequest title: {}, content: {}", request.title(), request.content());

        ArticleCreateResponse articleCreateResponse = articleService.create(
                request,
                hostUser.getUserAccountId().orElseThrow()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok(
                                articleCreateResponse,
                                hostUser.getHost().getBaseUrl()
                        )
                );
    }
}

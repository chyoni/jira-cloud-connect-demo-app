package kr.osci.addons.app.domain.board.controller.view;

import com.atlassian.connect.spring.AtlassianHostUser;
import kr.osci.addons.app.domain.board.service.ArticleService;
import kr.osci.addons.app.domain.board.service.request.ArticleCreateRequest;
import kr.osci.addons.app.domain.board.service.response.ArticleReadPageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final ArticleService articleService;

    @GetMapping
    public String boardMain(@AuthenticationPrincipal AtlassianHostUser hostUser,
                            @RequestParam(value = "page", required = false, defaultValue = "1") Long page,
                            Model model) {
        ArticleReadPageResponse articles = articleService.readAll(page, 10L);
        model.addAttribute("articles", articles);
        model.addAttribute("hostUser", hostUser);
        return "board/main";
    }

    @GetMapping("/new")
    public String create(@AuthenticationPrincipal AtlassianHostUser hostUser, Model model) {
        model.addAttribute("article", ArticleCreateRequest.empty());
        model.addAttribute("hostUser", hostUser);
        return "board/createForm";
    }
}

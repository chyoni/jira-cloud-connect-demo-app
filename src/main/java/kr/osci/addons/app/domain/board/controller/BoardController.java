package kr.osci.addons.app.domain.board.controller;

import com.atlassian.connect.spring.AtlassianHostUser;
import kr.osci.addons.app.domain.board.service.ArticleService;
import kr.osci.addons.app.domain.board.service.request.ArticleCreateRequest;
import kr.osci.addons.app.domain.board.service.response.ArticleReadPageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public String create(Model model) {
        model.addAttribute("article", ArticleCreateRequest.empty());
        return "board/createForm";
    }

    @PostMapping("/new")
    public String create(@AuthenticationPrincipal AtlassianHostUser authenticatedUser,
                         @Validated @ModelAttribute("article") ArticleCreateRequest article,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.debug("[create:45] binding errors : {}", bindingResult);
            return "board/createForm";
        }

        articleService.create(article, authenticatedUser);
        return "board/main";
    }
}

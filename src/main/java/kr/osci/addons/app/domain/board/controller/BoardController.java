package kr.osci.addons.app.domain.board.controller;

import kr.osci.addons.app.domain.board.service.ArticleService;
import kr.osci.addons.app.domain.board.service.response.ArticleReadPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final ArticleService articleService;

    @GetMapping
    public String boardMain(Model model,
                            @RequestParam(value = "page", required = false, defaultValue = "1") Long page) {
        ArticleReadPageResponse articles = articleService.readAll(page, 10L);
        model.addAttribute("articles", articles);
        return "board/main";
    }
}

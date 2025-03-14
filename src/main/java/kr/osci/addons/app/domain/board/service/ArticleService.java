package kr.osci.addons.app.domain.board.service;

import com.atlassian.connect.spring.AtlassianHostUser;
import kr.osci.addons.app.domain.board.entity.Article;
import kr.osci.addons.app.domain.board.repository.ArticleRepository;
import kr.osci.addons.app.domain.board.service.request.ArticleCreateRequest;
import kr.osci.addons.app.domain.board.service.response.ArticleCreateResponse;
import kr.osci.addons.app.domain.board.service.response.ArticleReadPageResponse;
import kr.osci.addons.app.domain.board.service.response.ArticleReadResponse;
import kr.osci.addons.app.domain.board.utils.PageLimitCalculator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public ArticleCreateResponse create(ArticleCreateRequest request, String writerId) {
        log.info("[create:27] writerId = {}", writerId);
        Article newArticle = articleRepository.save(
                Article.of(
                        request.title(),
                        request.content(),
                        writerId
                )
        );

        return ArticleCreateResponse.of(newArticle);
    }

    public ArticleReadPageResponse readAll(Long page, Long pageSize) {
        List<ArticleReadResponse> articles = articleRepository.findAllBy((page - 1) * pageSize, pageSize).stream()
                .map(ArticleReadResponse::of)
                .toList();

        return ArticleReadPageResponse.of(
                articles,
                articleRepository.count(PageLimitCalculator.calculatePageLimit(page, pageSize, 10L))
        );
    }

    public ArticleReadResponse read(Long articleId) {
        return articleRepository.findById(articleId)
                .map(ArticleReadResponse::of)
                .orElseThrow();
    }
}

package kr.osci.addons.app.domain.board.service.response;

import kr.osci.addons.app.domain.board.entity.Article;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleCreateResponse {
    private Long articleId;
    private String title;
    private String content;
    private String writerId;
    private LocalDateTime createdAt;

    public static ArticleCreateResponse of(Article article) {
        ArticleCreateResponse response = new ArticleCreateResponse();
        response.articleId = article.getArticleId();
        response.title = article.getTitle();
        response.content = article.getContent();
        response.writerId = article.getWriterId();
        response.createdAt = article.getCreatedAt();
        return response;
    }
}

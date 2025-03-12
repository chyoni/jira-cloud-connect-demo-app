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
public class ArticleReadResponse {
    private Long articleId;
    private String title;
    private String content;
    private String writerId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static ArticleReadResponse of(Article article) {
        ArticleReadResponse response = new ArticleReadResponse();
        response.articleId = article.getArticleId();
        response.title = article.getTitle();
        response.content = article.getContent();
        response.writerId = article.getWriterId();
        response.createdAt = article.getCreatedAt();
        response.modifiedAt = article.getModifiedAt();
        return response;
    }
}

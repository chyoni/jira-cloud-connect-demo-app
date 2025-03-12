package kr.osci.addons.app.domain.board.service.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleReadPageResponse {
    private List<ArticleReadResponse> articles;
    private Long totalCount;

    public static ArticleReadPageResponse of(List<ArticleReadResponse> articles, Long totalCount) {
        ArticleReadPageResponse articleReadPageResponse = new ArticleReadPageResponse();
        articleReadPageResponse.articles = articles;
        articleReadPageResponse.totalCount = totalCount;
        return articleReadPageResponse;
    }
}

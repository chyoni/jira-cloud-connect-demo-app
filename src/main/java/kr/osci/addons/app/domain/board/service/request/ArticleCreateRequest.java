package kr.osci.addons.app.domain.board.service.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record ArticleCreateRequest(@NotBlank @Length(min = 1, max = 50) String title,
                                   @NotBlank String content) {

    public static ArticleCreateRequest empty() {
        return new ArticleCreateRequest("", "");
    }
}

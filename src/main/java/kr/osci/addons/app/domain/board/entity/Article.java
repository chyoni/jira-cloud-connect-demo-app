package kr.osci.addons.app.domain.board.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "article")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;
    private String title;
    private String content;
    private String writerId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static Article of(String title,
                             String content,
                             String writerId) {
        Article article = new Article();
        article.title = title;
        article.content = content;
        article.writerId = writerId;
        article.createdAt = LocalDateTime.now();
        article.modifiedAt = LocalDateTime.now();
        return article;
    }
}

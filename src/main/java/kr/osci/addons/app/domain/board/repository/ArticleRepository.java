package kr.osci.addons.app.domain.board.repository;

import kr.osci.addons.app.domain.board.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(
            value = "select article.article_id, article.title, article.content, article.writer_id, article.writer_display_name, article.created_at, article.modified_at " +
                    "from (" +
                    "   select article.article_id " +
                    "   from article " +
                    "   order by article_id desc " +
                    "   limit :limit offset :offset " +
                    ") t left join article on article.article_id = t.article_id",
            nativeQuery = true
    )
    List<Article> findAllBy(@Param("offset") Long offset, @Param("limit") Long limit);

    @Query(
            value = "select count(*) " +
                    "from (" +
                    "   select article_id " +
                    "   from article " +
                    "   limit :limit " +
                    ") t",
            nativeQuery = true
    )
    Long count(@Param("limit") Long limit);
}

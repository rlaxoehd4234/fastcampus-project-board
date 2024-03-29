package com.fastcampus.projectboard.repository;

import com.fastcampus.projectboard.config.JpaConfig;
import com.fastcampus.projectboard.domain.Article;
import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(@Autowired ArticleRepository articleRepository,
                             @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @Test
    void givenTestDat_whenSelecting_thenWorksFine(){
        //given


        //when

        List<Article> articles = articleRepository.findAll();



        //then
        assertThat(articles).isNotNull().hasSize(0);
    }

    @DisplayName("update Test")
    @Test
    void givenTestDate(){
        Article article1 = Article.of("addon", "kim", "#taedong");
        articleRepository.save(article1);

        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springBoot";
        article.setHashtag(updatedHashtag);


}
}

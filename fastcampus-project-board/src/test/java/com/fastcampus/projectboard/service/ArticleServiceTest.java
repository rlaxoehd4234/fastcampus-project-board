package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.type.SearchType;
import com.fastcampus.projectboard.dto.ArticleDto;
import com.fastcampus.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut ; // Test 해야 하는 대상이다.
    @Mock private ArticleRepository articleRepository;
     /*검색
        각 게시글 페이지로 이동
        페이지네이션
        홈 버튼 -> 게시판 페이지로 리다이렉션
        정렬 기능
        */


    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticleList(){
        //Given


        //When
        List<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); // 제목, 본문, ID, 닉네임, 해시태그

        //then
        assertThat(articles).isNotNull();


    }
    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void ivenSearchArticleId_whenSearchingArticles_thenReturnsArticle(){
        ArticleDto articles = sut.searchArticle(1L);

        assertThat(articles).isNotNull();
    }

}
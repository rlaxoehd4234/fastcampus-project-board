package com.fastcampus.projectboard.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDto {
    private String title;
    private String content;
    private String hashtag;
    private String createdBy;
    private LocalDateTime createdAt;

    public ArticleDto(String title, String content, String hashtag, String createdBy, LocalDateTime createdAt) {
        this.title = title;
        this.content =content;
        this.hashtag = hashtag;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    @Builder
    public ArticleDto toEntity(String title, String content, String hashtag, String createdBy, LocalDateTime createdAt) {
       return new ArticleDto(title, content, hashtag, createdBy, createdAt);
    }




}

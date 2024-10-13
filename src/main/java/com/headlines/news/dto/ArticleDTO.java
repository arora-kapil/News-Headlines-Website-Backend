package com.headlines.news.dto;

import lombok.Data;

import java.util.Date;


@Data
public class ArticleDTO {
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Date publishedAt;
    private String content;
    private SourceDTO source;
}
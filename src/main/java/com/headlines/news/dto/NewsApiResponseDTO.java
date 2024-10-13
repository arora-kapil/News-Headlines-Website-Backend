package com.headlines.news.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NewsApiResponseDTO {
    private String status;
    private int totalResults;
    private List<ArticleDTO> articles;
}
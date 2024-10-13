package com.headlines.news.controller;

import com.headlines.news.dto.NewsApiResponseDTO;
import com.headlines.news.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/news")
@Slf4j
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/category")
    public NewsApiResponseDTO getNewsByCategory(@RequestParam(value = "category") String category) {
        log.debug("Fetching news headlines for category: {}", category);
        return newsService.getNewsHeadlinesBy(category);
    }

    @GetMapping("/search")
    public NewsApiResponseDTO searchNews(@RequestParam(value = "query") String query) {
        log.debug("Fetching news with query: {}", query);
        return newsService.searchNewsBy(query);
    }
}
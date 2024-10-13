package com.headlines.news.service;

import com.headlines.news.dto.NewsApiResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static java.util.Collections.emptyList;

@Service
@Slf4j
public class NewsService {
    @Value("${news.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate;

    public NewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "newsCache")
    public NewsApiResponseDTO getNewsHeadlinesBy(String category) {
        String url = String.format("https://newsapi.org/v2/top-headlines?pageSize=12&category=%s&apiKey=%s", category, apiKey);
        try {
            return restTemplate.getForObject(url, NewsApiResponseDTO.class);
        } catch (RestClientException e) {
            log.error("Error while fetching news headlines for category: {}", category);
        }
        return NewsApiResponseDTO.builder()
                .status("Failure")
                .articles(emptyList())
                .build();
    }

    @Cacheable(value = "newsCache")
    public NewsApiResponseDTO searchNewsBy(String query) {
        String url = String.format("https://newsapi.org/v2/everything?pageSize=12&q=%s&apiKey=%s", query, apiKey);
        try {
            return restTemplate.getForObject(url, NewsApiResponseDTO.class);
        } catch (RestClientException e) {
            log.error("Error while fetching news headlines for query: {}", query);
        }
        return NewsApiResponseDTO.builder()
                .status("Failure")
                .articles(emptyList())
                .build();
    }
}
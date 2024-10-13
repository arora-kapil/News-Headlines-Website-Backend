package com.headlines.news.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
@Slf4j
public class CacheConfig {

    private static final String NEWS_CACHE_KEY = "newsCache";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(NEWS_CACHE_KEY);
    }

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.HOURS)
    public void evictAllCachesAtIntervals() {
        log.debug("Clearing newsCache: {}", Instant.now());
        Objects.requireNonNull(cacheManager().getCache(NEWS_CACHE_KEY)).clear();
    }
}

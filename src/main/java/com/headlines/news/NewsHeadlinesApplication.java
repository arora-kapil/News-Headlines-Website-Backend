package com.headlines.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NewsHeadlinesApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsHeadlinesApplication.class, args);
    }
}

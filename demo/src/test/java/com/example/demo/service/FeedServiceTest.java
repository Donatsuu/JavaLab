package com.example.demo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedServiceTest {

    FeedService feedService = new FeedService();


    @Test
    void shouldReturnAllFeed() {
        var feed = feedService.getFeed();
        assertEquals(1, feed.size());
        assertEquals("Feed1", feed.get(0).getTitle());
    }

    @Test
    void shouldReturnTheFirstFeedIfGivenOne() {
        var feed = feedService.getFeedById(1);
        assertEquals("Feed1", feed.getTitle());
    }

    @Test
    void shouldReturnTheFirstFeedIfGivenTwo() {
        var feed = feedService.getFeedById(2);
        assertEquals("Feed2", feed.getTitle());
    }
}
package com.example.demo.controller;

import com.example.demo.model.FeedResponse;
import com.example.demo.service.FeedService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class FeedControllerTest {

    @Mock
    private FeedService feedService;

    @InjectMocks
    private FeedController feedController;

    @Test
    void shouldReturnFeed() {
        var feed = new FeedResponse();
        feed.setTitle("Title 1");
        var feedResponses = new ArrayList<FeedResponse>();
        feedResponses.add(feed);
        when(feedService.getFeed()).thenReturn(feedResponses);
        var response = feedController.getFeed();
        assertEquals(1, response.size());
        assertEquals("Title 1", response.get(0).getTitle());
        verify(feedService, times(1)).getFeed();
    }

    @Test
    void shouldReturnFirstFeedWhenGivenOneAsFeedId() {
        var feed = new FeedResponse();
        var feed2 = new FeedResponse();
        feed.setTitle("Title 1");
        feed2.setTitle("Title 2");
        var feedResponses = new ArrayList<FeedResponse>();
        feedResponses.add(feed);
        when(feedService.getFeed()).thenReturn(feedResponses);
        var response = feedController.getFeedById(1);
        assertEquals("Title 1", response.getTitle());
        verify(feedService, times(1)).getFeed();
    }
}
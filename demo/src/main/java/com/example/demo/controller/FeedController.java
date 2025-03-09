package com.example.demo.controller;


import com.example.demo.model.FeedResponse;
import com.example.demo.service.FeedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class FeedController {
    private final FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping("/feed")
    public ArrayList<FeedResponse> getFeed() {
        return this.feedService.getFeed();
    }

    @GetMapping("/feed/{id}")
    public FeedResponse getFeedById(@PathVariable Integer id) {
        return this.feedService.getFeedById(id);
    }
}

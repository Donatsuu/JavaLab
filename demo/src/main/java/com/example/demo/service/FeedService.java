package com.example.demo.service;


import com.example.demo.model.FeedResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class FeedService {

    private ArrayList<FeedResponse> feedArchives = new ArrayList<FeedResponse>(
            Arrays.asList(
                    new FeedResponse(1, "Feed1", "https://www.odds.com/images/feed1.png"),
                    new FeedResponse(2, "Feed2", "https://www.odds.com/images/feed2.png")
            )
    );

    public ArrayList<FeedResponse> getFeed() {
        var feed1 = new FeedResponse();
        feed1.setTitle("Feed1");
        feed1.setId(1);
        feed1.setImageUrl("https://www.odds.com/images/feed1.png");
        var feedList = new ArrayList<FeedResponse>();
        feedList.add(feed1);
        return feedList;
    }

    public FeedResponse getFeedById(Integer feedId) {
        return this.feedArchives.stream().filter(feed -> feed.getId() == feedId).toList().getFirst();
    }
}

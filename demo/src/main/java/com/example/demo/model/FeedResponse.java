package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor()
@AllArgsConstructor()
@Data
public class FeedResponse {
    int id;
    String title;
    String imageUrl;
}

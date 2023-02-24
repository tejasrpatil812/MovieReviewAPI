package com.example.moviereviews.controller;

import com.example.moviereviews.model.Review;
import com.example.moviereviews.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getMovies() {
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> createMovie(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(reviewService.create(payload.get("imdbId"), payload.get("body")), HttpStatus.CREATED);
    }

}

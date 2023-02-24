package com.example.moviereviews.service;

import com.example.moviereviews.model.Movie;
import com.example.moviereviews.model.Review;
import com.example.moviereviews.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public Review create(String imdbId, String body){
        Review review = new Review(body);
        review = reviewRepo.insert(review);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId")
                .is(imdbId)).apply(new Update().push("reviewIds").value(review.getId())).first();
        return review;
    }
}

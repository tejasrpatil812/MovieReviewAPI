package com.example.moviereviews.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String body;
    private Date createdAt;
    private Date updatedAt;
    public Review(String body) {
        this.body = body;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
}

package com.example.moviereviews.service;

import com.example.moviereviews.model.Movie;
import com.example.moviereviews.repo.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    public List<Movie> getAllMovies(){
        return movieRepo.findAll();
    }

    public Optional<Movie> getMovie(ObjectId id) {
        return movieRepo.findById(id);
    }

    public Optional<Movie> getMovieByImdb(String id) {
        return movieRepo.findMovieByImdbId(id);
    }
}

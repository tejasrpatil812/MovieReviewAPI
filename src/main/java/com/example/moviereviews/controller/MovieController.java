package com.example.moviereviews.controller;

import com.example.moviereviews.model.Movie;
import com.example.moviereviews.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable ObjectId id){
        return new ResponseEntity<>(movieService.getMovie(id), HttpStatus.OK);
    }

    @GetMapping("/imdb/{id}")
    public ResponseEntity<Optional<Movie>> getMovieByImdb(@PathVariable String id){
        return new ResponseEntity<>(movieService.getMovieByImdb(id), HttpStatus.OK);
    }
}

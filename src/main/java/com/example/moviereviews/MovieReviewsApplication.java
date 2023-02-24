package com.example.moviereviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MovieReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewsApplication.class, args);
	}

	@GetMapping("/ping")
	public String ping(){
		return "pong";
	}

}

package com.example.MovieService.controller;

import com.example.MovieService.model.Movie;
import com.example.MovieService.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public ResponseEntity<List<Movie>> moviesList() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Movie responseText = movieService.findMovie(id);
        return ResponseEntity.ok(responseText);
    }
/*    @PostMapping()
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie){

    }*/

}
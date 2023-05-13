package com.example.MovieService.controller;

import com.example.MovieService.model.Movie;
import com.example.MovieService.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Long id) {
        Optional<Movie> responseText = movieService.findById(id);
        return ResponseEntity.ok(responseText);
    }
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        if (movie.getName() == null || movie.getCategory() == null) {
            return ResponseEntity.badRequest().build();
        }
        movieService.addMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        try {
            Movie existingMovie = movieService.findById(id).get();
            existingMovie.setName(movie.getName());
            existingMovie.setCategory(movie.getCategory());
            return ResponseEntity.ok(existingMovie);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
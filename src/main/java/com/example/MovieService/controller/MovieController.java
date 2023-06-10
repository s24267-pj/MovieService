package com.example.MovieService.controller;

import com.example.MovieService.model.Movie;
import com.example.MovieService.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movie Controller", description = "Controller do Movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    @Operation(summary = "Get all movies", description = "Get all movies from database. The response is list of movie objects containing: id, name, category and availability.")
    public ResponseEntity<List<Movie>> moviesList() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a movie by id.", description = "The response is object Movie with id, name, category and availability.")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
            description = "Found the movie",
            content = { @Content(schema = @Schema(implementation = Movie.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content)}
    )
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

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }

    /*@PutMapping("/available/{id}")
    public Movie setMovieAvailable(@PathVariable Long id, @RequestBody Movie movie) {

        Optional<Movie> currentMovie = movieService.findById(id);
        movie.setIsAvailable(true);
        return movieService.setToAvailable();
    }*/
}
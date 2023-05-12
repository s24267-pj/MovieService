package com.example.MovieService.service;

import com.example.MovieService.model.Categories;
import com.example.MovieService.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movieList;

    public MovieService() {
        this.movieList = new ArrayList<>();
    }

    public List<Movie> getAllMovies() {
        return movieList;
    }

    public Movie findMovie(long id) {
        for (Movie movie : movieList) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        throw new RuntimeException("Movie not found");
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

}

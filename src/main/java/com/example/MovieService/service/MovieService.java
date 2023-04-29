package com.example.MovieService.service;

import com.example.MovieService.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    List<Movie> movieList = new ArrayList<>();

    public List<Movie> getAllMovies() {
        return List.of();
    }

    public Movie findMovie(long id) {
        for (Movie movie : movieList) {
            if (movie.getId() == id) {
                return movieList.get(movieList.indexOf(id));
            }
        }
        throw new RuntimeException();
    }

}

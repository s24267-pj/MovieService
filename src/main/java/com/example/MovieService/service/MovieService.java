package com.example.MovieService.service;

import com.example.MovieService.model.Movie;
import com.example.MovieService.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


/*    public List<Movie> getAllMovies() {
        return List.of();
    }

    public Movie findMovie(long id) {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(10, "Polik", Categories.HORROR));
        for (Movie movie : movieList) {
            if (movie.getId() == id) {
                return movieList.get(movieList.indexOf(id));
            }
        }
        throw new RuntimeException();
    }*/

    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public ResponseEntity<Void> deleteMovie(Long id){
        movieRepository.deleteById(id);
        return null;
    }
}

package com.example.MovieService.repository;

import com.example.MovieService.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

@Query("SELECT movie FROM Movie movie WHERE movie.id = ?1")
    Optional<Movie> findById(Long aLong);

@Query("select movie from Movie movie")
    List<Movie> findAll();


}

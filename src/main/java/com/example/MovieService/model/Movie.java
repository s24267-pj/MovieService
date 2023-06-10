package com.example.MovieService.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jdk.jfr.Name;
import org.springframework.web.bind.annotation.ModelAttribute;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Movie id", example = "1", readOnly = true, required = true)
    private Long id;
    @Schema(description = "Name of the movie", example = "Harry Potter")
    private String name;
    @Enumerated(EnumType.STRING)
    @Schema(description = "Category of the movie")
    private Categories category;
    @Schema(description = "Movie availability", defaultValue = "true", example = "true")
    private boolean isAvailable;

    public Movie(long id, String name, Categories category, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

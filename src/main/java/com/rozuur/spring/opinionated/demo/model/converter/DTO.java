package com.rozuur.spring.opinionated.demo.model.converter;

import com.rozuur.spring.opinionated.demo.model.db.MovieEntity;
import com.rozuur.spring.opinionated.demo.model.dto.Movie;

public final class DTO {

    public static Movie from(MovieEntity entity) {
        return new Movie(entity.getTitle(), entity.getDirector(), entity.getReleaseDate());
    }

    public static MovieEntity toMovieEntity(Movie movie) {
        MovieEntity e = new MovieEntity();
        e.setTitle(movie.getTitle());
        e.setDirector(movie.getDirector());
        e.setReleaseDate(movie.getReleaseDate());
        return e;
    }
}

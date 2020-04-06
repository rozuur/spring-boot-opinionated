package com.rozuur.spring.opinionated.demo.model.converter;

import com.rozuur.spring.opinionated.demo.model.db.Movie;
import com.rozuur.spring.opinionated.demo.model.dto.MovieDto;

public final class DTO {

    public static MovieDto from(Movie movie) {
        return new MovieDto(movie.getTitle(), movie.getDirector(), movie.getReleaseDate());
    }

    public static Movie toMovieEntity(MovieDto movie) {
        Movie e = new Movie();
        e.setTitle(movie.getTitle());
        e.setDirector(movie.getDirector());
        e.setReleaseDate(movie.getReleaseDate());
        return e;
    }
}

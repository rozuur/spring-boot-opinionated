package com.rozuur.spring.opinionated.demo.model.mapper;

import com.rozuur.spring.opinionated.demo.model.db.MovieEntity;
import com.rozuur.spring.opinionated.demo.model.dto.Movie;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie entityToMovie(MovieEntity movieEntity);

    MovieEntity movieToEntity(Movie movie);
}

package com.rozuur.spring.opinionated.demo.model.mapper;

import com.rozuur.spring.opinionated.demo.model.db.MovieEntity;
import com.rozuur.spring.opinionated.demo.model.dto.Movie;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    Movie entityToMovie(MovieEntity movieEntity);

    MovieEntity movieToEntity(Movie movie);
}

package com.rozuur.spring.opinionated.demo.controller;

import com.rozuur.spring.opinionated.demo.exception.ExceptionUtils;
import com.rozuur.spring.opinionated.demo.model.converter.DTO;
import com.rozuur.spring.opinionated.demo.model.db.MovieEntity;
import com.rozuur.spring.opinionated.demo.model.dto.Movie;
import com.rozuur.spring.opinionated.demo.service.MovieService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "${application.api.prefix.v1}")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/movies")
    public List<Movie> movies() {
        return service.movies().stream().map(DTO::from).collect(Collectors.toList());
    }

    @GetMapping("/movies/{id}")
    public Movie movie(@PathVariable Long id) {
        return service.movie(id).map(DTO::from).orElseThrow(ExceptionUtils.notFoundId(MovieEntity.class, id));
    }

    @PostMapping("/movies")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Movie createPack(@Valid @RequestBody Movie movie) {
        return DTO.from(service.addMovie(DTO.toMovieEntity(movie)));
    }

}

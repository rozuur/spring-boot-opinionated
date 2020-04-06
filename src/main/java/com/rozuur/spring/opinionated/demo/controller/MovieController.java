package com.rozuur.spring.opinionated.demo.controller;

import com.rozuur.spring.opinionated.demo.model.db.Movie;
import com.rozuur.spring.opinionated.demo.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "${application.api.prefix}")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/movies")
    public List<Movie> movie() {
        return service.movies();
    }

}

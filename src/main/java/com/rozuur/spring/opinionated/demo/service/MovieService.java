package com.rozuur.spring.opinionated.demo.service;

import com.rozuur.spring.opinionated.demo.model.db.Movie;
import com.rozuur.spring.opinionated.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }


    public Optional<Movie> movie(Long id) {
        return repository.findById(id);
    }

    public List<Movie> movies() {
        return repository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return repository.save(movie);
    }

    public List<Movie> movies(String director) {
        return repository.findAllByDirector(director);
    }

}

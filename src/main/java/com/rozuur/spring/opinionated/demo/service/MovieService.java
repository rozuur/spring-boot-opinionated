package com.rozuur.spring.opinionated.demo.service;

import com.rozuur.spring.opinionated.demo.model.db.MovieEntity;
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

    public Optional<MovieEntity> movie(Long id) {
        return repository.findById(id);
    }

    public List<MovieEntity> movies() {
        return repository.findAll();
    }

    public MovieEntity addMovie(MovieEntity movie) {
        return repository.save(movie);
    }

    public List<MovieEntity> movies(String director) {
        return repository.findAllByDirector(director);
    }

}

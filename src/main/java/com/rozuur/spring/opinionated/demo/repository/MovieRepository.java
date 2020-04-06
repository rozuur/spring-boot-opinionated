package com.rozuur.spring.opinionated.demo.repository;

import com.rozuur.spring.opinionated.demo.model.db.MovieEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    List<MovieEntity> findAllByDirector(String director);
}

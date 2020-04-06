package com.rozuur.spring.opinionated.demo.model.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;

import java.time.LocalDate;

@Value
public class Movie {
    @NotBlank
    String title;

    @NotBlank
    String director;

    LocalDate releaseDate;
}

package com.rozuur.spring.opinionated.demo.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

import java.time.LocalDate;

@Data
public class Movie {
    @NotBlank
    String title;

    @NotBlank
    String director;

    LocalDate releaseDate;
}

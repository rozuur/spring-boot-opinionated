package com.rozuur.spring.opinionated.demo.model.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Value
public final class MovieDto {
    @NotBlank
    private String title;

    @NotBlank
    private String director;

    private Date releaseDate;
}

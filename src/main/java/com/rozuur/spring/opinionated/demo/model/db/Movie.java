package com.rozuur.spring.opinionated.demo.model.db;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String director;

    private Date releaseDate;

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
}

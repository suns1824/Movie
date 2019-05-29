package com.movie.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Movie {
    private Integer movieId;

    private String movieName;

    private Integer imdbId;

    private String movieDirector;

    private String movieActor;

    private String moviePicture;

    private String year;

    private BigDecimal score;

    private Integer scoreCount;

    private String movieIntro;

}
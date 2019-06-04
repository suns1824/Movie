package com.movie.model;

import lombok.Data;

@Data
public class Rating {

    private Integer userId;

    private Integer movieId;

    private Float rating;

    private Integer timestamp;

}
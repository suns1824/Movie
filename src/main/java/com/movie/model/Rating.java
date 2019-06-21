package com.movie.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rating {

    private Integer userId;

    private Integer movieId;

    private Float rating;

    private Integer timestamp;

    
}
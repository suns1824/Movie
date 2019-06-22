package com.movie.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Recommand {
    private Integer userId;

    private Integer movieid1;

    private Integer movieid2;

    private Integer movieid3;

    private Integer movieid4;

    private Integer movieid5;

}
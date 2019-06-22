package com.movie.dal.daoobj;

import lombok.Data;

import java.io.Serializable;

@Data
public class RatingDo implements Serializable{

    private static final long serialVersionUID = -5300104873409918933L;

    private Integer userId;

    private Integer movieId;

    private Float rating;

    private Integer timeStamp;

}

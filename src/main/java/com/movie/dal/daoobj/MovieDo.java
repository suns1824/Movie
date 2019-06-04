package com.movie.dal.daoobj;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieDo implements Serializable{
    private static final long serialVersionUID = 4161326705046662045L;
    private int movieId;
    private String title;
    private String genres;
    private int imdbId;
    private int tmdbId;
}

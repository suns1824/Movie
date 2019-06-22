package com.movie.service;

import com.movie.model.Movie;
import com.movie.model.Rating;
import com.movie.model.User;
import com.movie.model.common.Result;

import java.util.List;

public interface MovieService {
    List<Rating> findRatingByUserId(int id, int pageIndex, int pageSize);

    List<Movie> getGreaterThanxMovieList(float rating, int pageIndex, int pageSize);

    List<User> getMovfavorUserList(int movieId);



    //以上没有用result，不改啦

    Result commitRating(Rating rating);
}

package com.movie.service;

import com.movie.dal.daoobj.MovieDo;
import com.movie.dal.daoobj.RatingDo;
import com.movie.dal.daoobj.UserDo;

import java.util.List;

public interface MovieService {
    List<RatingDo> findRatingByUserId(int id);

    List<MovieDo> getGreaterThanxMovieList(float rating, int pageIndex, int pageSize);

    List<UserDo> getMovfavorUserList(int movieId);
}

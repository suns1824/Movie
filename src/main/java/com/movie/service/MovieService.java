package com.movie.service;

import com.movie.dal.daoobj.MovieDo;
import com.movie.dal.daoobj.RatingDo;
import com.movie.dal.daoobj.UserDo;
import com.movie.model.Rating;
import com.movie.model.common.Result;

import java.util.List;

public interface MovieService {
    List<RatingDo> findRatingByUserId(int id);

    List<MovieDo> getGreaterThanxMovieList(float rating, int pageIndex, int pageSize);

    List<UserDo> getMovfavorUserList(int movieId);



    //以上没有用result，不改啦

    Result commitRating(Rating rating);
}

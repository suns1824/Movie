package com.movie.service.impl;

import com.movie.dal.MovieDao;
import com.movie.dal.daoobj.MovieDo;
import com.movie.dal.daoobj.RatingDo;
import com.movie.dal.daoobj.UserDo;
import com.movie.model.Rating;
import com.movie.model.common.Result;
import com.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<RatingDo> findRatingByUserId(int userId) {
        List<RatingDo> list = movieDao.selectByUserId(userId);
        return list;
    }

    @Override
    public List<MovieDo> getGreaterThanxMovieList(float rating, int pageIndex, int pageSize) {
        List<MovieDo> list = movieDao.selectGreaterThanxMovieList(rating, pageIndex, pageSize);
        return list;
    }

    @Override
    public List<UserDo> getMovfavorUserList(int movieId) {
        return null;
    }

    @Override
    public Result commitRating(Rating rating) {
        return null;
    }
}

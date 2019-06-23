package com.movie.service.impl;

import com.movie.cache.MovieCacheManager;
import com.movie.dal.MovieDao;
import com.movie.dal.daoobj.MovieDo;
import com.movie.dal.daoobj.RatingDo;
import com.movie.dal.daoobj.UserDo;
import com.movie.model.Movie;
import com.movie.model.Rating;
import com.movie.model.User;
import com.movie.model.common.Result;
import com.movie.service.MovieService;
import com.movie.util.convert.MovieConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private MovieCacheManager movieCacheManager;

    @Override
    public List<Rating> findRatingByUserId(int userId, int pageIndex, int pageSize) {

        List<RatingDo> daolist = movieCacheManager.getRatingByUserId(userId, pageIndex, pageSize);
        if (daolist == null) {
            daolist = movieDao.selectByUserId(userId, pageIndex, pageSize);
            movieCacheManager.setRatingByUserId(userId, pageIndex, pageSize, daolist);
        }
        List<Rating> list = MovieConvert.convertRating(daolist);
        return list;
    }

    @Override
    public List<Movie> getGreaterThanxMovieList(float rating, int pageIndex, int pageSize) {
        List<MovieDo> daolist = movieDao.selectGreaterThanxMovieList(rating, pageIndex, pageSize);
        List<Movie> list = MovieConvert.convertMovie(daolist);
        return list;
    }

    @Override
    public List<User> getMovfavorUserList(int movieId) {
        return null;
    }

    /*
    数据库和redis的缓存一致性处理：
    1.选择先更新数据库，再删缓存策略,；
    2.选择先删缓存，再更新数据库，A线程删后，B线程数据库读取并存入redis，A更新数据库，导致不一致，可以通过延时双删策略
     */
    @Override
    public Result commitRating(Rating rating) {
        return null;
    }
}

package com.movie.controller;

import com.movie.dal.MovieDao;
import com.movie.dal.daoobj.MovieDo;
import com.movie.dal.daoobj.RatingDo;
import com.movie.dal.daoobj.UserDo;
import com.movie.model.*;
import com.movie.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
@Api(value = "电影页面", description = "")
public class MovieController {

    @Autowired
    MovieService movieService;

    //按照userid查询,返回集合
    @ApiOperation(value = "userId查询电影评分")
    @RequestMapping("/findRatingByUserId")
    public List<RatingDo> findRatingByUserId(@RequestParam("userId") Integer userID){
        List<RatingDo> list = movieService.findRatingByUserId(userID);
        return list;
    }

    /*查出所有评分超过x分的电影的信息
    select movies.movieId,movies.title,movies.genres,links.imdbId,links.tmdbId
    from ratings
    join movies on movies.movieId = ratings.movieId
    join links on ratings.movieId = links.movieId
    where ratings.rating > 4.5
    group by ratings.movieId
    order by links.imdbId
    limit 20;
     */
    @ApiOperation(value = "评分x以上的movieid,tile,genres,imdbid,tmdbid,按照imdbid排序")
    @RequestMapping("/findGreaterThanxImdb")
    public List<MovieDo> getGreaterThanxMovieList(@RequestParam("rating") float rating,
                                                  @RequestParam("pageIndex") int pageIndex,
                                                  @RequestParam("pageSize") int pageSize) {
        List<MovieDo> list = movieService.getGreaterThanxMovieList(rating, pageIndex, pageSize);
        return list;
    }

    /*根据movieId查出给分最高的10名用户
    select t.userId from (select * from ratings where movieId = 1) as t order by rating desc limit 10;
    根据title查出给分最高的10名用户
    select t0.userId from
        (select ratings.userId, ratings.movieId, ratings.rating, movies.title from ratings
        join movies on ratings.movieId = movies.movieId
        where movies.title = "Toy Story (1995)"
        ) as t0
    order by t0.rating desc limit 10;

    这两个理论上等价，但是给出的结果不相等。
     */
    @ApiOperation(value = "给电影评分最高的十位用户")
    @RequestMapping("/getMovfavorUser")
    public List<UserDo> getMovfavorUserList(@RequestParam("movieId") int movieId) {
        List<UserDo> list = movieService.getMovfavorUserList(movieId);
        return list;
    }

}

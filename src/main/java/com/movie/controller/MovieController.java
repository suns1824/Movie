package com.movie.controller;

import com.movie.dal.daoobj.MovieDo;
import com.movie.dal.daoobj.UserDo;
import com.movie.model.*;
import com.movie.model.common.Result;
import com.movie.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
现在不考虑cookie，session等身份信息处理，因为还没用户模块,返回应该统一为Result。
 */

@RestController
@RequestMapping("/movie")
@Api(value = "电影页面", description = "")
public class MovieController {

    @Autowired
    MovieService movieService;

    //按照userid查询,返回集合
    @ApiOperation(value = "userId查询电影评分")
    @RequestMapping("/findRatingByUserId")
    public List<Rating> findRatingByUserId(@RequestParam("userId") Integer userID,
                                           @RequestParam("pageIndex") Integer pageIndex,
                                           @RequestParam("pageSize") Integer pageSize){
        List<Rating> list = movieService.findRatingByUserId(userID, pageIndex, pageSize);
        return list;
    }

    /*查出所有评分超过x分的电影的信息
    select movies.movieId,movies.title,movies.genres,links.imdbId,links.tmdbId
    from ratings
    join movies on movies.movieId = ratings.movieId
    join links on ratings.movieId = links.movieId
    where ratings.rating > 4.5
    group by ratings.movieI x c
    order by links.imdbId
    limit 20;
     */
    @ApiOperation(value = "评分x以上的movieid,tile,genres,imdbid,tmdbid,按照imdbid排序")
    @RequestMapping("/findGreaterThanxImdb")
    public List<Movie> getGreaterThanxMovieList(@RequestParam("rating") Float rating,
                                                  @RequestParam("pageIndex") Integer pageIndex,
                                                  @RequestParam("pageSize") Integer pageSize) {
        List<Movie> list = movieService.getGreaterThanxMovieList(rating, pageIndex, pageSize);
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
    public List<User> getMovfavorUserList(@RequestParam("movieId") Integer movieId) {
        List<User> list = movieService.getMovfavorUserList(movieId);
        return list;
    }

    /*
    提交打分数据
    insert into ratings
    values(userId, movieId, rating, timestamp)
     */
    public Result commitRating(@RequestParam("userId") Integer userId,
                                       @RequestParam("movieId") Integer movieId,
                                       @RequestParam("rating") Float rate,
                                       @RequestParam("timestamp") Integer ratingTime) {
        Rating rating = Rating.builder().userId(userId).movieId(movieId).rating(rate).timestamp(ratingTime).build();

        Result result = movieService.commitRating(rating);

        return result;
    }



    /*
     查找某一类型的电影中评分最高的10部电影,满足打分人数超过10次:
     先查哪些电影超过十次评分：
     select movieId, count(rating) count from ratings group by movieId having count > 100;

     select a.movieId, movies.title, avg(a.rating) score from ratings a
     join movies on movies.movieId = a.movieId
     join  (select b.movieId, count(b.rating) count from ratings b group by b.movieId having count > 100) as c
     on a.movieId = c.movieId
     where movies.genres like '%Comedy%'
     group by a.movieId
     order by score desc
     limit 10
     */
    @ApiOperation(value = "查找某一类型的电影中评分最高的10部电影")
    @RequestMapping("/getTopMovies")
    public List<Movie> getTopMovies(@RequestParam("genres") String genre) {
        return null;
    }


}
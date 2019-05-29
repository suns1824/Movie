package com.movie.controller;

import com.movie.dal.MovieDao;
import com.movie.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
@Api(value = "电影页面", description = "")
public class MovieController {

    @Autowired
    private MovieDao movieDao;

    //按照userid查询,返回集合
    @ApiOperation(value = "userId查询电影评分")
    @RequestMapping("/findRatingByUserId")
    public List<Rating> findRatingByUserId(Integer userID){
        List<Rating> list = movieDao.selectByUserId(userID);
        return list;
    }

}

package com.movie.dal;

import com.movie.dal.daoobj.MovieDo;
import com.movie.dal.daoobj.RatingDo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MovieDao {
    @Resource(name = "movieMybatisTemplate")
    private SqlSessionTemplate movieMybatisTemplate;

    public List<RatingDo> selectByUserId(int userId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("userId", userId);
        return movieMybatisTemplate.selectList("RatingMapper.selectByUserId", map);
    }

    public List<MovieDo> selectGreaterThanxMovieList(float rating, int pageIndex, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("rating", rating);
        map.put("pageIndex", pageIndex);
        map.put("pageSize", pageSize);
        return movieMybatisTemplate.selectList("RatingMapper.selectGreterThanxMovieList", map);
    }


}

package com.movie.dal;

import com.movie.model.Rating;
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

    public List<Rating> selectByUserId(int userId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("userId", userId);
        return movieMybatisTemplate.selectList("RatingMapper.selectByUserId", map);
    }
}

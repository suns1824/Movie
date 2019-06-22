package com.movie.cache;

import com.alibaba.fastjson.JSON;
import com.movie.dal.daoobj.RatingDo;;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MovieCacheManager extends AbstractCacheManager {

    private static final int HALF_HOUR = 12 * 3600;

    @Resource
    private RedisClient movieRedisClient;

    @Override
    RedisClient getRedisClient() {
        return movieRedisClient;
    }

    public List<RatingDo> getRatingByUserId(int userId, int index, int size) {
        String key = getKey(userId, index, size);
        String value;
        value = (String) movieRedisClient.get(key);
        if (! StringUtils.isEmpty(value)) {
            List<RatingDo> list = JSON.parseArray(value, RatingDo.class);
            return list;
        }
        return null;
    }

    public void setRatingByUserId(int userId, int index, int size, List<RatingDo> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        String key = getKey(userId, index, size);
        String value = JSON.toJSONString(list);
        movieRedisClient.set(key, HALF_HOUR);
    }

    private String getKey(int userId, int index, int size) {
        return "Movie" + userId + index + size;
    }
}

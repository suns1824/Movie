package com.movie.cache;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisNode;

import java.util.Collection;
import java.util.List;
import java.util.Map;

abstract class AbstractCacheManager {
    protected final Logger logger = LoggerFactory.getLogger("cacheLog");

    abstract RedisClient getRedisClient();

}

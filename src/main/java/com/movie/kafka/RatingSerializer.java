package com.movie.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.model.Rating;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class RatingSerializer implements Serializer<Rating> {

    private ObjectMapper mapper;
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        mapper = new ObjectMapper();
    }

    @Override
    public byte[] serialize(String topic, Rating data) {
        byte[] ret = null;
        try {
            ret = mapper.writeValueAsString(data).getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public void close() {

    }
}

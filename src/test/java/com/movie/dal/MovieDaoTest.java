package com.movie.dal;

import com.movie.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"classpath*:/spring/*.xml"})
public class MovieDaoTest extends AbstractTestNGSpringContextTests {
    @Autowired
    MovieDao movieDao;
    @Test
    public void selectByUserId() {
        List<Rating> list = new ArrayList<>();
        list = movieDao.selectByUserId(1);
        assertEquals(20, list.size());
    }
}
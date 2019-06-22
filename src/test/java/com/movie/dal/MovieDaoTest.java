package com.movie.dal;

import com.movie.dal.daoobj.MovieDo;
import com.movie.dal.daoobj.RatingDo;
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
        List<RatingDo> list = new ArrayList<>();
        list = movieDao.selectByUserId(1, 5, 10);
        assertEquals(10, list.size());
    }

    @Test
    public void selectGreaterThanxMovieList() {
        List<MovieDo> list = movieDao.selectGreaterThanxMovieList(4.5f, 0, 20);
        assertEquals(list.get(19).getMovieId(), 3306);
    }
}
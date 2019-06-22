package com.movie.util.convert;

import com.google.common.collect.Lists;
import com.movie.dal.daoobj.MovieDo;
import com.movie.dal.daoobj.RatingDo;
import com.movie.model.Movie;
import com.movie.model.Rating;

import java.util.List;

public class MovieConvert {
    public static List<Movie> convertMovie(List<MovieDo> doList) {
        List<Movie> list = Lists.newArrayList();
        for(MovieDo movieDo: doList) {
            Movie movie = Movie.builder()
                    .movieId(movieDo.getMovieId())
                    .movieName(movieDo.getTitle())
                    .genres(movieDo.getGenres())
                    .imdbId(movieDo.getImdbId())
                    .build();
            list.add(movie);
        }
        return list;
    }

    public static List<Rating> convertRating(List<RatingDo> doList) {
        List<Rating> list = Lists.newArrayList();
        for(RatingDo ratingDo : doList) {
            Rating rating = Rating.builder()
                    .userId(ratingDo.getUserId())
                    .movieId(ratingDo.getMovieId())
                    .rating(ratingDo.getRating())
                    .timestamp(ratingDo.getTimeStamp())
                    .build();
            list.add(rating);
        }
        return list;
    }
}

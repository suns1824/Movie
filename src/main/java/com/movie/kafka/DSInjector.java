package com.movie.kafka;

public class DSInjector {
    public static void main(String[] args) {
        Producer movieProducer = new Producer("movieRatings");
        movieProducer.start();
    }
}

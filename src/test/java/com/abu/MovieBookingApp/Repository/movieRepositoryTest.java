package com.abu.MovieBookingApp.Repository;

import com.abu.MovieBookingApp.Model.movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class movieRepositoryTest {

    movieRepository repository;
    @Autowired
    public movieRepositoryTest(movieRepository repository) {
        this.repository = repository;
    }




}
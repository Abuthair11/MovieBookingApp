package com.abu.MovieBookingApp.Service;/*
 *Created by Abuthair
 * Date:13/09/2023
 * time:12:43
 *projectName:MovieBookingApp

 */

import com.abu.MovieBookingApp.Model.movie;
import com.abu.MovieBookingApp.Repository.movieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class movieServiceImpl implements  iMovieService{
    movieRepository repository;
    @Autowired
    public movieServiceImpl(movieRepository repository) {
        this.repository = repository;
    }

    @Override
    public movie addMovie(movie movies) {
        return  repository.save(movies);
    }
}

package com.abu.MovieBookingApp.Service;/*
 *Created by Abuthair
 * Date:13/09/2023
 * time:12:42
 *projectName:MovieBookingApp

 */

import com.abu.MovieBookingApp.Model.movie;
import com.abu.MovieBookingApp.payload.MovieResponse;

import java.util.List;

public interface iMovieService {
    public movie addMovie(movie movies);



    public movie updateMovie(movie movie);


    public void deleteMovie(int movieId);

    public movie getMovie(int movieId);

    MovieResponse getAll(int pageNo, int pageSize,String  sortBy,String sortDir);

    movie getByMovieName(String name);


    public List<movie> getByMovieGenre(String genre);

    public  List<movie> getByMovieDirector(String  director);

//    public  movie getByMovieDescription(String description);

    List<movie> getByMovieNameLike(String name);
}

package com.abu.MovieBookingApp.Service;/*
 *Created by Abuthair
 * Date:13/09/2023
 * time:12:43
 *projectName:MovieBookingApp

 */

import com.abu.MovieBookingApp.Exception.MovieNotFoundException;
import com.abu.MovieBookingApp.Model.movie;
import com.abu.MovieBookingApp.Repository.movieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public movie updateMovie(movie movie) {
//        movie movieid = repository.findById(movieId).get();
//        if(movieid == null){
//            throw new MovieNotFoundException("Movie ID not found");
//        }
        return repository.save(movie);
    }

    @Override
    public void deleteMovie(int  movieId) {
         repository.deleteById(movieId);
    }

    @Override
    public movie getMovie(int movieId) {
        movie findMovie = repository.findById(movieId).get();
        if(findMovie == null){
            throw new MovieNotFoundException("Movie ID not found");
        }
        return findMovie;
    }

    @Override
    public List<movie> getAll() {
        List<movie> getAllMovie =  repository.findAll();
        if(getAllMovie.isEmpty()){
            throw new MovieNotFoundException("No movies found");
        }
        return getAllMovie;

    }

    @Override
    public movie getByMovieName(String name) {
        movie movieName = repository.findByMovieName(name);
        if(movieName == null){
            throw new MovieNotFoundException("Movie Name not found");
        }
        return movieName;
    }

    @Override
    public  List<movie> getByMovieGenre(String genre) {
        List<movie> movieGerman = repository.findByMovieGenre(genre);
        if(movieGerman == null){
            throw new MovieNotFoundException("Movie Genre not found");
        }
        return movieGerman;
    }

    @Override
    public  List<movie> getByMovieDirector(String director) {
        List<movie> movieDirector = repository.findByMovieDirector(director);
        if(movieDirector == null){
            throw new MovieNotFoundException("Movie Director not found");
        }
        return movieDirector;

    }

//    @Override
//    public  movie getByMovieDescription(String description) {
//        movie movieDescription = repository.findByMovieDescription(description);
//        if(movieDescription == null){
//            throw new MovieNotFoundException("Movie Description not found");
//        }
//        return movieDescription;
//    }


}

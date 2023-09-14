package com.abu.MovieBookingApp.Controller;/*
 *Created by Abuthair
 * Date:13/09/2023
 * time:11:23
 *projectName:MovieBookingApp

 */


import com.abu.MovieBookingApp.Model.movie;
import com.abu.MovieBookingApp.Service.iMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movie/v1")
public class movieController{


    iMovieService movieService;
    @Autowired
    public movieController(iMovieService movieService) {
        this.movieService = movieService;
    }
/**
 *Working as expected
 * */
    @PostMapping("/addMovie")
   public movie  addMovie(@RequestBody  movie movie){
      return movieService.addMovie(movie);
    }

   /**
    * Not Working Need to check
    * why it is not working
    *
    * */
    @PutMapping("/updateMovie/{movieId}")
    public movie updateMovie(@RequestBody  movie movie){
        return movieService.updateMovie(movie);
    }

     /*
     * Working As expected
     *
     * */
    @DeleteMapping("/delete/{movieId}")
    public void deleteMovie(@PathVariable int movieId){
        movieService.deleteMovie(movieId);
    }

    /**
     * Working as expected
     *
     * */
    @GetMapping("/getMovie/{movieId}")
    public movie getMovie(@PathVariable  int movieId){
        return movieService.getMovie(movieId);
    }

    /**
     * Working as expected
     *
     * */
    @GetMapping("/Movies")
    List<movie> getAll()   {
        return movieService.getAll();
    }

    /**
     * Working as expected
     *
     * */
    @GetMapping("/movie/{name}")
    movie getByMovieName(@PathVariable  String name)  {
        return movieService.getByMovieName(name);
    }

    /**
     * Working as expected
     *
     * */
    @GetMapping("/movieGen/{genre}")

    public  List<movie> getByMovieGenre(@PathVariable  String genre){
        return movieService.getByMovieGenre(genre);
    }

    /**
     * Working as expected
     *
     * */

    @GetMapping("/movieDir/{director}")
    public  List<movie> getByMovieDirector(@PathVariable String  director){
        return movieService.getByMovieDirector(director);
    }

//    @GetMapping("/movieDes/{description}")
//    public  movie getByMovieDescription(String description){
//        return movieService.getByMovieDescription(description);
//    }

}


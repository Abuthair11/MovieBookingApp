package com.abu.MovieBookingApp.Controller;/*
 *Created by Abuthair
 * Date:13/09/2023
 * time:11:23
 *projectName:MovieBookingApp

 */


import com.abu.MovieBookingApp.Model.movie;
import com.abu.MovieBookingApp.Service.iMovieService;
import com.abu.MovieBookingApp.Utils.AppConstants;
import com.abu.MovieBookingApp.payload.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
     * added pagenation and sorting methods
     *
     * */
    @GetMapping("/Movies")
    MovieResponse getAll(
            @RequestParam(value  ="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required=false) int pageNo,
            @RequestParam(value ="pageSize",defaultValue =AppConstants.DEFAULT_PAGE_SIZE,required=false) int pageSize,
            @RequestParam(value ="sortBy",defaultValue =AppConstants.DEFAULT_SORT_BY,required=false) String sortBy,
            @RequestParam(value ="sortDir",defaultValue =AppConstants.DEFAULT_SORT_ORDER,required=false) String sortDir
    )   {
        return movieService.getAll(pageNo, pageSize,sortBy,sortDir);
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

    @GetMapping("/moviesLike/{movieLike}")
    public  List<movie> getByMovieNameLike(@PathVariable String movieLike){
        return movieService.getByMovieNameLike(movieLike);
    }
}


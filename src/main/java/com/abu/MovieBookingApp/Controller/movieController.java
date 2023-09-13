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

    @PostMapping("/addMovie")
   public movie  addMovie(@RequestBody  movie movie){
      return movieService.addMovie(movie);
    }


}

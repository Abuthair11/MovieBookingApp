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
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
   public ResponseEntity<movie>  addMovie(@RequestBody  movie movie){
        HttpHeaders httpHeaders =  new HttpHeaders();
        httpHeaders.add("Desc","Create a new Movie");
      return new ResponseEntity<>(movieService.addMovie(movie), httpHeaders, HttpStatus.CREATED);
    }

   /**
    * Not Working Need to check
    * why it is not working
    *
    * */
    @PutMapping("/updateMovie/{movieId}")
    public ResponseEntity<movie> updateMovie(@RequestBody  movie movie){
         HttpHeaders httpHeaders =  new HttpHeaders();
         httpHeaders.add("Desc","Updating the movie ");
        return new ResponseEntity<>(movieService.updateMovie(movie),httpHeaders,HttpStatus.OK);
    }

     /*
     * Working As expected
     *
     * */
    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int movieId){
    HttpHeaders httpHeaders  = new HttpHeaders();
    httpHeaders.add("Desc","Deleting the movie ");
    movieService.deleteMovie(movieId);
    return new ResponseEntity<>(httpHeaders,HttpStatus.OK);
    }

    /**
     * Working as expected
     *
     * */
    @GetMapping("/getMovie/{movieId}")
    public ResponseEntity<movie> getMovie(@PathVariable  int movieId){
        HttpHeaders httpHeaders =  new HttpHeaders();
        httpHeaders.add("Desc","Get Movie from Movie Id from Database");
        return new ResponseEntity<>(movieService.getMovie(movieId),httpHeaders,HttpStatus.OK);
    }

    /**
     * Working as expected
     * added pagenation and sorting methods
     *
     * */
    @GetMapping("/Movies")
    public ResponseEntity<MovieResponse> getAll(
            @RequestParam(value  ="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required=false) int pageNo,
            @RequestParam(value ="pageSize",defaultValue =AppConstants.DEFAULT_PAGE_SIZE,required=false) int pageSize,
            @RequestParam(value ="sortBy",defaultValue =AppConstants.DEFAULT_SORT_BY,required=false) String sortBy,
            @RequestParam(value ="sortDir",defaultValue =AppConstants.DEFAULT_SORT_ORDER,required=false) String sortDir
    )   {
        HttpHeaders httpHeaders =  new HttpHeaders();
        httpHeaders.add("Desc","Get All Movies from Database");
        return new ResponseEntity<>(movieService.getAll(pageNo, pageSize,sortBy,sortDir),httpHeaders,HttpStatus.OK);
    }

    /**
     * Working as expected
     *
     * */
    @GetMapping("/movie/{name}")
     public ResponseEntity <movie> getByMovieName(@PathVariable  String name)  {
        HttpHeaders httpHeaders =  new HttpHeaders();
        httpHeaders.add("Desc","Get Movie from Name");
        return new ResponseEntity<>(movieService.getByMovieName(name),HttpStatus.OK);
    }

    /**
     * Working as expected
     *
     * */
    @GetMapping("/movieGen/{genre}")

    public  ResponseEntity<List<movie>> getByMovieGenre(@PathVariable  String genre){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Desc"," List of movie form Genre");
        return new ResponseEntity<>(movieService.getByMovieGenre(genre),httpHeaders,HttpStatus.OK);
    }

    /**
     * Working as expected
     *
     * */

    @GetMapping("/movieDir/{director}")
    public ResponseEntity< List<movie>> getByMovieDirector(@PathVariable String  director){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Desc"," List of movie form Director");
        return new ResponseEntity<>(movieService.getByMovieDirector(director),HttpStatus.OK);
    }

    @GetMapping("/moviesLike/{movieLike}")
    public  ResponseEntity<List<movie>> getByMovieNameLike(@PathVariable String movieLike){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Desc"," List of movie form Movie Name Like ");
        return new ResponseEntity<>(movieService.getByMovieNameLike(movieLike),httpHeaders,HttpStatus.OK);
    }
}


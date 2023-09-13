package com.abu.MovieBookingApp.Repository;
/*
 *Created by Abuthair
 * Date:13/09/2023
 * time:10:56
 *projectName:MovieBookingApp

 */

import com.abu.MovieBookingApp.Model.movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface movieRepository extends JpaRepository<movie,Integer> {



    public movie findByMovieName(String movieName);

}

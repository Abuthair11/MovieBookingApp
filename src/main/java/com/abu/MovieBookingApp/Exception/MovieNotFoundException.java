package com.abu.MovieBookingApp.Exception;/*
 *Created by Abuthair
 * Date:13/09/2023
 * time:11:12
 *projectName:MovieBookingApp

 */

public class MovieNotFoundException extends  RuntimeException{

    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message){
            super(message);
        }
}

package com.abu.MovieBookingApp.payload;/*
 *Created by Abuthair
 * Date:18/09/2023
 * time:19:13
 *projectName:MovieBookingApp

 */

import lombok.Getter;

import java.util.Date;
@Getter

public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details, String description) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}

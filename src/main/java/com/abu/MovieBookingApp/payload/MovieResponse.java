package com.abu.MovieBookingApp.payload;/*
 *Created by Abuthair
 * Date:14/09/2023
 * time:10:36
 *projectName:MovieBookingApp

 */

import com.abu.MovieBookingApp.Model.movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieResponse {

    private List<movie> content;
    private int pageNo;
    private int pageSize;
    private int totalElement;
    private int totalPages;
    private boolean last;
}

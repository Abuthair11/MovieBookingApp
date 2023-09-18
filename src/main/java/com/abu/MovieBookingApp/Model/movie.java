package com.abu.MovieBookingApp.Model;

/**
*Created by Abuthair
 * Date:13/09/2023
 * time:10:39
 *projectName:MovieBookingApp
 */

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class movie {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_generator"
    )
    @SequenceGenerator(
            name = "movie_generator",
            sequenceName = "movie_sequence_generator",
            allocationSize = 1
    )
    private int movieId;
    @Column(nullable = false)
    private String movieName;
    @Column(nullable = false)
    private String movieDescription;
    @Column(nullable = false)
    private String movieImageUrl;
    @Column(nullable = false)
    private String movieDuration;
    @Column(nullable = false)
    private String movieGenre;
    @Column(nullable = false)
    private String movieDirector;
    @Column(nullable = false)
    private String movieActors;
    @Column(nullable = false)
    private String movieRating;

    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;

}

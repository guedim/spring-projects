package com.guedim.grpcflix.movie.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@ToString
public class Movie {

    @Id
    private Integer id;
    private String title;
    private Integer year;
    private Double rating;
    private String genre;

}

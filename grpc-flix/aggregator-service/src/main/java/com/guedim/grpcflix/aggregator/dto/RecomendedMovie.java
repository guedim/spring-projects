package com.guedim.grpcflix.aggregator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecomendedMovie {

    private String title;
    private int year;
    private double rating;
}

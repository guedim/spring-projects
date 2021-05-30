package com.guedim.grpcflix.aggregator.controller;

import com.guedim.grpcflix.aggregator.dto.RecomendedMovie;
import com.guedim.grpcflix.aggregator.dto.UserGenre;
import com.guedim.grpcflix.aggregator.service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AggregatorController {

    @Autowired
    private UserMovieService userMovieService;

    @GetMapping("/user/{loginId}")
    public List<RecomendedMovie> getMovies(@PathVariable String loginId) {
        return userMovieService.getUserMovieSuggestions(loginId);
    }

    @PutMapping("/user/")
    public void setUserGenre(@RequestBody UserGenre userGenre) {
        userMovieService.setUserGenre(userGenre);
    }
}

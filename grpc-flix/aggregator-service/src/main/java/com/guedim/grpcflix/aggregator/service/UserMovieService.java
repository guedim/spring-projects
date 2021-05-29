package com.guedim.grpcflix.aggregator.service;

import com.guedim.grpcflix.aggregator.dto.RecomendedMovie;
import com.guedim.grpcflix.aggregator.dto.UserGenre;
import com.guedim.grpcflix.common.Genre;
import com.guedim.grpcflix.movie.MovieSearchRequest;
import com.guedim.grpcflix.movie.MovieSearchResponse;
import com.guedim.grpcflix.movie.MovieServiceGrpc;
import com.guedim.grpcflix.user.UserGenreUpdateRequest;
import com.guedim.grpcflix.user.UserResponse;
import com.guedim.grpcflix.user.UserSearchRequest;
import com.guedim.grpcflix.user.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMovieService {

    @GrpcClient("user-service")
    private UserServiceGrpc.UserServiceBlockingStub userStub;

    @GrpcClient("movie-service")
    private MovieServiceGrpc.MovieServiceBlockingStub  movieStub;

    public List<RecomendedMovie> getUserMovieSuggestions(String loginId) {
        UserSearchRequest userSearchRequest = UserSearchRequest.newBuilder().setLoginId(loginId).build();
        UserResponse userResponse = userStub.getUserGenre(userSearchRequest);

        MovieSearchRequest movieSearchRequest = MovieSearchRequest.newBuilder().setGenre(userResponse.getGenre()).build();
        MovieSearchResponse movieSearchResponse = movieStub.getMovies(movieSearchRequest);

        return  movieSearchResponse.getMovieList()
                .stream()
                .map(movieDto ->
                    new RecomendedMovie(
                            movieDto.getTitle(),
                            movieDto.getYear(),
                            movieDto.getRating())
                )
                .collect(Collectors.toList());
    }


    public void setUserGenre(UserGenre userGenre) {

        UserGenreUpdateRequest userGenreUpdateRequest = UserGenreUpdateRequest.newBuilder()
                .setLoginId(userGenre.getLoginId())
                .setGenre(Genre.valueOf(userGenre.getGenre().toUpperCase()))
                .build();
        UserResponse userResponse = userStub.updateUserGenre(userGenreUpdateRequest);
    }
}

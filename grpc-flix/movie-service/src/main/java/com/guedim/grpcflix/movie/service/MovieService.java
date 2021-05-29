package com.guedim.grpcflix.movie.service;

import com.guedim.grpcflix.movie.MovieDto;
import com.guedim.grpcflix.movie.MovieSearchRequest;
import com.guedim.grpcflix.movie.MovieSearchResponse;
import com.guedim.grpcflix.movie.MovieServiceGrpc;
import com.guedim.grpcflix.movie.repository.MovieRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class MovieService extends MovieServiceGrpc.MovieServiceImplBase {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void getMovies(MovieSearchRequest request, StreamObserver<MovieSearchResponse> responseObserver) {

        List<MovieDto> movieDtoList = movieRepository.getMovieByGenreOrderByYearDesc(request.getGenre().toString())
                .stream()
                .map(movie ->
                        MovieDto.newBuilder()
                                .setTitle(movie.getTitle())
                                .setYear(movie.getYear())
                                .setRating(movie.getRating())
                                .build()
                )
                .collect(Collectors.toList());

        MovieSearchResponse response = MovieSearchResponse.newBuilder()
                .addAllMovie(movieDtoList)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

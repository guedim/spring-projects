package com.guedim.grpcflix.user.service;

import com.guedim.grpcflix.user.UserGenreUpdateRequest;
import com.guedim.grpcflix.user.UserResponse;
import com.guedim.grpcflix.user.UserSearchRequest;
import com.guedim.grpcflix.user.UserServiceGrpc;
import com.guedim.grpcflix.user.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void getUserGenre(UserSearchRequest request, StreamObserver<UserResponse> responseObserver) {

        UserResponse.Builder builder = UserResponse.newBuilder();
        userRepository.findById(request.getLoginId())
                .ifPresent(user -> builder.setName(user.getName())
                        .setLoginId(user.getLogin())
                        .setGenre(com.guedim.grpcflix.common.Genre.valueOf(user.getGenre().toUpperCase())));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    @Transactional
    public void updateUserGenre(UserGenreUpdateRequest request, StreamObserver<UserResponse> responseObserver) {

        UserResponse.Builder builder = UserResponse.newBuilder();
        userRepository.findById(request.getLoginId())
                .ifPresent(user -> {
                    user.setGenre(request.getGenre().toString());
                    builder.setName(user.getName())
                            .setLoginId(user.getLogin())
                            .setGenre(com.guedim.grpcflix.common.Genre.valueOf(user.getGenre().toUpperCase()));
                });
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}

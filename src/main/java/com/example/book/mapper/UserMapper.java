package com.example.book.mapper;
import com.example.book.entity.UserEntity;
import com.example.book.model.request.UserRequest;
import com.example.book.model.response.UserResponse;

public class UserMapper {

    public static UserResponse mapToResponse(UserEntity user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public static UserEntity mapToEntity(UserRequest userRequest) {
        return UserEntity.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .build();
    }
}

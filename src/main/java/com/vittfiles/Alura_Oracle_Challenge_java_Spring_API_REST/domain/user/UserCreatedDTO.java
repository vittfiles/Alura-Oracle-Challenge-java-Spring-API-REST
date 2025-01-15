package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user;

public record UserCreatedDTO(
        String token,
        String sessionType,
        UserDTO user
) {

    public UserCreatedDTO(String token, String sessionType, User user){
        this(token, sessionType, new UserDTO(user));
    }
}

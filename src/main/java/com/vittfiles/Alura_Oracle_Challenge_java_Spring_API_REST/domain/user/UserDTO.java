package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user;

public record UserDTO(
        Long id,
        String name,
        String email
) {
    public UserDTO(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}

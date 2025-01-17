package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user;

import jakarta.validation.constraints.*;

public record DataCreateUser(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @Size(min = 6)
        String password
) {
}

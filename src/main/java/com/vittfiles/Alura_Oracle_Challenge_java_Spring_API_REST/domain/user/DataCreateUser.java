package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataCreateUser(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Min(6)
        String password
) {
}

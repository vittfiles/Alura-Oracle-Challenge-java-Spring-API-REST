package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.session;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record DataCreateSession(
        @NotBlank
        @Email
        String email,
        @Min(6)
        String password
) {
}

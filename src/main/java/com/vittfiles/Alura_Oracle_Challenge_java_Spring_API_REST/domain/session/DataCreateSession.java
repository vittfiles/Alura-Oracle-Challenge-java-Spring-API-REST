package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.session;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DataCreateSession(
        @NotBlank
        @Email
        String email,
        @Size(min = 6)
        String password
) {
}

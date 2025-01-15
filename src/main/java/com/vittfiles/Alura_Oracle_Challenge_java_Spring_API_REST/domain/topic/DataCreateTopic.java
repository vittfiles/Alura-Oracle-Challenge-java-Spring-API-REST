package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic;

import jakarta.validation.constraints.NotBlank;

public record DataCreateTopic(
        @NotBlank
        String title,
        @NotBlank
        String message,
        Long course
) {
}

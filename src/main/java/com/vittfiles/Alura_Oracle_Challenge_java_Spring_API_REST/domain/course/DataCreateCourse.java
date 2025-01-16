package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course;

import jakarta.validation.constraints.NotBlank;

public record DataCreateCourse(
        @NotBlank
        String name,
        @NotBlank
        String category
) {
}

package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateDataTopic(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        Long author,
        @NotNull
        Long course
) {
        public CreateDataTopic(DataUpdateTopic data){
                this(data.title(),data.message(),data.author(),data.course());
        }
}

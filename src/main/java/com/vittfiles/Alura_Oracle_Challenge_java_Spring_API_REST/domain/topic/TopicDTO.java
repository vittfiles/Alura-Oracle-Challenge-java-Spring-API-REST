package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic;

import java.time.LocalDateTime;

public record TopicDTO(
        Long id,
        String title,
        String message,
        LocalDateTime createdAt,
        String status,
        Long authorId,
        String author,
        Long course
) {
    public TopicDTO(Topic topic){
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreatedAt(),
                topic.getStatus().getSpanishName(),
                topic.getAuthor().getId(),
                topic.getAuthor().getName(),
                null
                );
    }
}

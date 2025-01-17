package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course.Course;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course.CourseDTO;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.UserDTO;

import java.time.LocalDateTime;

public record TopicFullDTO(
        Long id,
        String title,
        String message,
        LocalDateTime createdAt,
        String status,
        UserDTO author,
        CourseDTO course
) {
    public TopicFullDTO(Topic topic){
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreatedAt(),
                topic.getStatus().getSpanishName(),
                new UserDTO(topic.getAuthor()),
                new CourseDTO(topic.getCourse())
        );
    }
}

package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course;

public record CourseDTO(
        Long id,
        String name,
        String category
) {
    public CourseDTO(Course course){
        this(course.getId(),course.getName(),course.getCategory());
    }
}

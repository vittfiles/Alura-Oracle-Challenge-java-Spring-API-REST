package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c WHERE c.name = :name")
    Optional<Course> getCourseByName(String name);
}

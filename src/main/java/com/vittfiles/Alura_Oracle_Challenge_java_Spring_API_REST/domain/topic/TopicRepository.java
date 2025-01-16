package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Query("SELECT t FROM Topic t WHERE t.title = :title AND t.message = :message")
    Optional<Topic> getTopicRepeated(String title, String message);
}

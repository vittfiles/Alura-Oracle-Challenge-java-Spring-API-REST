package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.controller;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.DataCreateTopic;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.Topic;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.TopicDTO;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.TopicRepository;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public ResponseEntity<List<TopicDTO>> getTopics(){
        var topics = topicRepository.findAll().stream()
                .map(TopicDTO::new).toList();
        return ResponseEntity.ok(topics);
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody @Valid DataCreateTopic data){
        var userData = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Topic topic = topicRepository.save(new Topic(data,(User) userData));
        return ResponseEntity.ok(topic);
    }
}

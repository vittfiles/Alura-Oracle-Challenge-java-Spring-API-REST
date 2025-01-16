package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.controller;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.CustomValidationException;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course.CourseRepository;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.*;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.create_validators.CreateTopicValidator;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.User;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private List<CreateTopicValidator> createTopicValidators;

    @GetMapping
    public ResponseEntity<List<TopicDTO>> getTopics(){
        var topics = topicRepository.findAll().stream()
                .map(TopicDTO::new).toList();
        return ResponseEntity.ok(topics);
    }

    @PostMapping
    public ResponseEntity<TopicDTO> createTopic(@RequestBody @Valid DataCreateTopic data){
//        var userData = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        createTopicValidators.forEach(v -> v.validate(data));

        var course = courseRepository.findById(data.course());
        var user = userRepository.findById(data.author());

        Topic topic = topicRepository.save(new Topic(data,user.get(),course.get()));
        return ResponseEntity.ok(new TopicDTO(topic));
    }

    @PutMapping
    public ResponseEntity updateTopic(@RequestBody @Valid DataUpdateTopic data){
        return ResponseEntity.ok(null);
    }
}

package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.controller;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course.CourseRepository;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.*;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.create_validators.CreateTopicValidator;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.UserRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private List<CreateTopicValidator> createTopicValidators;

    @Autowired
    private UpdateTopicService updateTopicService;

    @GetMapping
    public ResponseEntity<Page<TopicDTO>> getTopics(@PageableDefault(sort = "createdAt", direction = Sort.Direction.ASC) Pageable pagination){
        var topics = topicRepository.findAll(pagination).map(TopicDTO::new);
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicFullDTO> getTopic(@PathVariable Long id){
        var topic = topicRepository.findById(id);
        if(topic.isEmpty()){
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok(new TopicFullDTO(topic.get()));
    }

    @PostMapping
    public ResponseEntity<TopicDTO> createTopic(@RequestBody @Valid CreateDataTopic data){
//        var userData = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        createTopicValidators.forEach(v -> v.validate(data));

        var course = courseRepository.findById(data.course());
        var user = userRepository.findById(data.author());

        Topic topic = topicRepository.save(new Topic(data,user.get(),course.get()));
        return ResponseEntity.ok(new TopicDTO(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDTO> updateTopic(@RequestBody @Valid DataUpdateTopic data, @PathVariable Long id){
        var topic = updateTopicService.update(data, id);
        return ResponseEntity.ok(new TopicDTO(topic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopic(@PathVariable Long id){
        topicRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

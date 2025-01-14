package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @GetMapping
    public ResponseEntity getTopics(){
        return ResponseEntity.ok(null);
    }
}

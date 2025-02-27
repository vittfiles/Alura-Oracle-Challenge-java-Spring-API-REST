package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.controller;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.CustomValidationException;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course.*;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.Topic;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.TopicRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable Long id){
        var course = courseRepository.findById(id);
        if(course.isEmpty()){
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new CourseDTO(course.get()));
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getCourses(){
        var courses = courseRepository.findAll().stream()
                .map(CourseDTO::new).toList();
        return ResponseEntity.ok(courses);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCurse(@RequestBody @Valid DataCreateCourse data){
        try {
            var course = courseRepository.save(new Course(data));
            return ResponseEntity.ok(new CourseDTO(course));
        } catch (DataIntegrityViolationException e) {
            throw new CustomValidationException("El curso ya existe");
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody @Valid DataUpdateCourse data, @PathVariable Long id){
        var courseOptional = courseRepository.findById(id);
        if(courseOptional.isEmpty()){
            throw new CustomValidationException("El curso con el id ("+id+") no existe");
        }
        if(courseRepository.getCourseByName(data.name()).isPresent()){
            throw new CustomValidationException("Ya existe un curso con ese nombre");
        }
        var course = courseOptional.get();
        course.setName(data.name());
        course.setCategory(data.category());
        return ResponseEntity.ok(new CourseDTO(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity updateCourse(@PathVariable Long id){
        var topics = topicRepository.getTopicsByCourseId(id);
        if(!topics.isEmpty()){
            var ids = topics.stream().map(Topic::getId).toList();
            if(ids.size() > 1){
                throw new CustomValidationException("El curso no puede ser borrado por referenciar los tópicos "+ids);
            }else{
                throw new CustomValidationException("El curso no puede ser borrado por referenciar el tópico "+ids);
            }
        }
        courseRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}

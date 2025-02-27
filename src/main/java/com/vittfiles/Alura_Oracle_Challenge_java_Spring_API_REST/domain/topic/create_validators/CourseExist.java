package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.create_validators;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.CustomValidationException;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course.CourseRepository;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.CreateDataTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseExist implements CreateTopicValidator, UpdateTopicValidator {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void validate(CreateDataTopic data) {
        var course = courseRepository.findById(data.course());

        if(course.isEmpty()){
            throw new CustomValidationException("No existe el curso");
        }
    }

    @Override
    public void validate(CreateDataTopic data, Long id) {
        var course = courseRepository.findById(data.course());

        if(course.isEmpty()){
            throw new CustomValidationException("No existe el curso");
        }
    }
}

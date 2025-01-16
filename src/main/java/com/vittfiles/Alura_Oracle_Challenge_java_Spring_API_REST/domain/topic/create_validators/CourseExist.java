package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.create_validators;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.CustomValidationException;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course.CourseRepository;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.DataCreateTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseExist implements CreateTopicValidator{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void validate(DataCreateTopic data) {
        var course = courseRepository.findById(data.course());

        if(course.isEmpty()){
            throw new CustomValidationException("No existe el curso");
        }
    }
}

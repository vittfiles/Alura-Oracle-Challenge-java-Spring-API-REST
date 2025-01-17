package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.CustomValidationException;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.course.CourseRepository;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.create_validators.UpdateTopicValidator;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateTopicService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private List<UpdateTopicValidator> topicValidators;

    public Topic update(DataUpdateTopic data, Long id){

        Status status = null;

        try {
            status = Status.fromSpanishName(data.status());
        } catch (IllegalArgumentException e){
            throw new CustomValidationException(e.getMessage());
        }

        var topicOptional = topicRepository.findById(id);

        if(topicOptional.isEmpty()){
            throw new CustomValidationException("El tópico con id ("+id+") no existe");
        }

        topicValidators.forEach(v -> v.validate(new CreateDataTopic(data), id));

        var topic = topicOptional.get();

        if(data.author() != topic.getAuthor().getId()){
            var author = userRepository.findById(data.author());
            topic.setAuthor(author.get());
        }

        if(data.course() != topic.getCourse().getId()){
            var course = courseRepository.findById(data.course());
            topic.setCourse(course.get());
        }

        topic.setTitle(data.title());
        topic.setMessage(data.message());
        topic.setStatus(status);

        return topic;
    }
}

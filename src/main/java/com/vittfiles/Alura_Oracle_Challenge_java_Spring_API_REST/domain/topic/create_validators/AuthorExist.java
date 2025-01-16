package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.create_validators;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.CustomValidationException;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.CreateDataTopic;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.UserRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorExist implements CreateTopicValidator{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(CreateDataTopic data) {
        var user = userRepository.findById(data.author());

        if(user.isEmpty()){
            throw new CustomValidationException("No existe el autor del tópico");
        }
    }

    @Override
    public void validate(CreateDataTopic data, Long id) {
        var user = userRepository.findById(data.author());

        if(user.isEmpty()){
            throw new CustomValidationException("No existe el autor del tópico");
        }
    }
}

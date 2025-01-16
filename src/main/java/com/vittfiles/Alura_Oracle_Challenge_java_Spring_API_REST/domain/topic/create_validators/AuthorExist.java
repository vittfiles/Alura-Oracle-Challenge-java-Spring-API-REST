package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.create_validators;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.CustomValidationException;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.DataCreateTopic;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorExist implements CreateTopicValidator{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(DataCreateTopic data) {
        var user = userRepository.findById(data.author());

        if(user.isEmpty()){
            throw new CustomValidationException("No existe el autor del tópico");
        }
    }
}

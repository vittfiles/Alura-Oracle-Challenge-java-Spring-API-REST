package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.create_validators;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.CustomValidationException;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.DataCreateTopic;
import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicExist implements CreateTopicValidator{

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(DataCreateTopic data) {
        var topicDB = topicRepository.getTopicRepeated(data.title(),data.message());

        if(topicDB.isPresent()){
            throw new CustomValidationException("El tópico ya existe");
        }
    }
}

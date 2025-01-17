package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.create_validators;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.CreateDataTopic;

public interface UpdateTopicValidator {
    void validate(CreateDataTopic data, Long id);
}

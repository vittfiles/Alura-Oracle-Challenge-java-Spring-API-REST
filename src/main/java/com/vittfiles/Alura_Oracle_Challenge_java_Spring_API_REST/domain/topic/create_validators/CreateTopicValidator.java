package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.create_validators;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.DataCreateTopic;

public interface CreateTopicValidator {
    void validate(DataCreateTopic data);
}

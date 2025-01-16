package com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.create_validators;

import com.vittfiles.Alura_Oracle_Challenge_java_Spring_API_REST.domain.topic.CreateDataTopic;
import jakarta.validation.constraints.Null;

public interface CreateTopicValidator {
    void validate(CreateDataTopic data);
    void validate(CreateDataTopic data, Long id);
}

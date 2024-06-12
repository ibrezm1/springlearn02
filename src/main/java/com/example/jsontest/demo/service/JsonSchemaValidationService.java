package com.example.jsontest.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.kafka.core.KafkaTemplate;

import java.util.Set;

@Service
public class JsonSchemaValidationService {

    private static final Logger log = LoggerFactory.getLogger(JsonSchemaValidationService.class);

    @Autowired
    private JsonSchema jsonSchema;

    @Autowired
    private EmailService emailService;

    @Autowired
    private GCPStorageService gcpStorageService;


    @Value("${kafka.topic.name}")
    private String TOPIC_NAME;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    // Custom class to hold original message and errors
    public static class ValidationResult {
        private JsonNode originalMessage;
        private Set<ValidationMessage> errors;

        public ValidationResult(JsonNode originalMessage, Set<ValidationMessage> errors) {
            this.originalMessage = originalMessage;
            this.errors = errors;
        }

        public JsonNode getOriginalMessage() {
            return originalMessage;
        }

        public Set<ValidationMessage> getErrors() {
            return errors;
        }
    }

    public ValidationResult validateJson(JsonNode jsonNode) {
        Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

        if (errors.isEmpty()) {
            // Event is valid.
            log.info("Event is valid");
            kafkaTemplate.send(TOPIC_NAME, jsonNode.toString());
            // Send email notification
            emailService.sendSimpleMessage("foldedgoat@gmail.com", "Valid JSON Event", "The JSON event is valid:\n" + jsonNode.toString());
            gcpStorageService.uploadJsonToGCPStorage("test-bucketz-01", "test", "test.json", "{\"json\": \"event\"}");

        } else {
            // Event is invalid.
            log.info("Event is invalid");
        }

        return new ValidationResult(jsonNode, errors);
    }
}
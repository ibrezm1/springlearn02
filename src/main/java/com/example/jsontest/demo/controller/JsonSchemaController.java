package com.example.jsontest.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsontest.demo.service.JsonSchemaValidationService;
import com.example.jsontest.demo.service.JsonSchemaValidationService.ValidationResult;


import com.fasterxml.jackson.databind.JsonNode;
@RestController
public class JsonSchemaController {
    @Autowired
    private JsonSchemaValidationService service;

    @PostMapping("/validate")
    public ValidationResult validateEvent( @RequestBody JsonNode jsonNode ){

        return service.validateJson(jsonNode);

    }
}

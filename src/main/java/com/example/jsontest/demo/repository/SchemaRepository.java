package com.example.jsontest.demo.repository;

import com.example.jsontest.demo.model.SchemaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchemaRepository extends MongoRepository<SchemaDocument, String> {
    SchemaDocument findBySchemaName(String schemaName);
}

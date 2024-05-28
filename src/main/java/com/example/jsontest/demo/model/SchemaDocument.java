package com.example.jsontest.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "schemas")
public class SchemaDocument {

    @Id
    private String id;
    private String schemaName;
    private String schemaContent;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getSchemaContent() {
        return schemaContent;
    }

    public void setSchemaContent(String schemaContent) {
        this.schemaContent = schemaContent;
    }
}

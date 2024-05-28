package com.example.jsontest.demo.config;

import com.example.jsontest.demo.model.SchemaDocument;
import com.example.jsontest.demo.repository.SchemaRepository;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    private static final String SCHEMA_NAME = "test";

    @Autowired
    private SchemaRepository schemaRepository;

    /*
    private static final String SCHEMA_VALIDATION_FILE = "/jsonSchema.json";

    @Bean
    public JsonSchema jsonSchema() {
        return JsonSchemaFactory
                .getInstance(SpecVersion.VersionFlag.V7)
                .getSchema(getClass().getResourceAsStream(SCHEMA_VALIDATION_FILE));
    }
     */
    @Bean
    public JsonSchema jsonSchema() {
        SchemaDocument schemaDocument = schemaRepository.findBySchemaName(SCHEMA_NAME);
        if (schemaDocument != null) {
            String schemaContent = schemaDocument.getSchemaContent();
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            return factory.getSchema(schemaContent);
        } else {
            throw new IllegalArgumentException("Schema not found in MongoDB");
        }
    }

}

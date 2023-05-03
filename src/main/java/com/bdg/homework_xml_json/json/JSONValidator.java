package com.bdg.homework_xml_json.json;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JSONValidator {

    /**
     * Validates a JSON file against a JSON schema file using the Jackson library.
     * @param jsonFile The path to the JSON file to be validated.
     * @param schemaFile The schema file against which the JSON file will be validated.
     * @throws RuntimeException if there is an IOException when reading the JSON or schema file,
     * or if there is a ProcessingException during validation.
     */
    public static void validate(Path jsonFile, File schemaFile) {
        try {

            String json = new String(Files.readAllBytes(jsonFile));

            ObjectMapper mapper = new ObjectMapper();
            JsonNode schemaNode = mapper.readTree(schemaFile);

            JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
            JsonSchema schema = schemaFactory.getJsonSchema(schemaNode);

            schema.validate(mapper.readTree(json));
            System.out.println("Validation passed successfully: ");

        } catch (IOException | ProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.ngrok.basic.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ngrok.basic.model.Event;
import com.ngrok.basic.service.EventService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WebhookController {

    private final MongoTemplate mongoTemplate;
    private final EventService eventService;

    public WebhookController(MongoTemplate mongoTemplate, EventService eventService) {
        this.mongoTemplate = mongoTemplate;
        this.eventService = eventService;
    }

    @PostMapping("pd-webhook")
    public ResponseEntity<String> getWebhook(@RequestBody JsonNode payload) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode eventNode = payload.get("event");
        Event event = objectMapper.convertValue(eventNode, Event.class);
        Event savedEvent = eventService.saveEvent(event);
        return ResponseEntity.ok("Event saved with ID: " + savedEvent.getId());

        // For using the MongoTemplate change the payload datatype to Object.
            // mongoTemplate.save(payload,"webhookPayloads");
            // return ResponseEntity.ok("Webhook received successfully");

        // To analyse the structure of the document
            // analyzeDocumentStructure(payload);
    }

    private void analyzeDocumentStructure(JsonNode payload) {
        traverseJsonNode(payload, "");
    }

    private void traverseJsonNode(JsonNode node, String prefix) {
        if (node.isObject()) {
            node.fields().forEachRemaining(entry -> traverseJsonNode(entry.getValue(), prefix + entry.getKey() + "."));
        } else if (node.isArray() && node.size() > 0) {
            traverseJsonNode(node.get(0), prefix);
        } else {
            String fieldPath = prefix.substring(0, prefix.length() - 1);
            String fieldType = determineFieldType(node);
            System.out.println(fieldPath + " - " + fieldType);
        }
    }

    private String determineFieldType(JsonNode node) {
        if (node.isBoolean()) {
            return "boolean";
        } else if (node.isInt()) {
            return "int";
        } else if (node.isLong()) {
            return "long";
        } else if (node.isFloat() || node.isDouble()) {
            return "double";
        } else if (node.isTextual()) {
            return "String";
        } else {
            return "Object";
        }
    }

    private String formatJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            Object jsonObject = objectMapper.readValue(json, Object.class);
            return objectMapper.writeValueAsString(jsonObject);
        } catch (Exception e) {
            // Handle exception if unable to format JSON
            return json;
        }
    }
}

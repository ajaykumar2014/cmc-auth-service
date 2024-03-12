package com.lbg.cmc.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.lbg.cmc.auth.ConfluentClient;
import com.lbg.cmc.config.PropertyConfig;
import com.lbg.cmc.model.TopicRequestBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "OAuth to Confluent Cloud")
@RequestMapping("/cmc/api")
public class ConfluentRestController {

    @Autowired
    private ConfluentClient confluentClient;

    @Autowired
    PropertyConfig propertyConfig;


    @ApiOperation(value = "Push Key/Value message to Confluent Cloud Topic", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully push the message"),
            @ApiResponse(code = 500, message = "Internal Service errors")
    }
    )
    @PostMapping("/topic/{topicName}/records")
    public ResponseEntity<?> produceRecords(@PathVariable String topicName, @RequestBody JsonNode body) {
        return ResponseEntity.ok(confluentClient.produceRecords(propertyConfig.getClusterId(), topicName, body));
    }

    @ApiOperation(value = "Create Topic on Confluent Cloud", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created topic"),
            @ApiResponse(code = 500, message = "Internal Service errors")
    }
    )
    @PostMapping("/topic/{topicName}")
    public ResponseEntity<?> createTopic(@PathVariable String topicName) {
        TopicRequestBody topicRequestBody = new TopicRequestBody(topicName);
        return ResponseEntity.ok(confluentClient.createTopic(propertyConfig.getClusterId(), topicRequestBody));
    }

    @ApiOperation(value = "Create Topic on particular cluster in Confluent Cloud", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created topic"),
            @ApiResponse(code = 500, message = "Internal Service errors")
    }
    )
    @PostMapping("/clusters/{clusterId}/topics/{topicName}")
    public ResponseEntity<?> createTopic(@PathVariable String clusterId, @PathVariable String topicName) {
        TopicRequestBody topicRequestBody = new TopicRequestBody(topicName);
        return ResponseEntity.ok(confluentClient.createTopic(clusterId, topicRequestBody));
    }
}

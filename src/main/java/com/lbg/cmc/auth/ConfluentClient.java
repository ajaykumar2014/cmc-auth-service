package com.lbg.cmc.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.lbg.cmc.config.ConfluentConfig;
import com.lbg.cmc.model.TopicRequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "confluent.rest.api", url = "${confluent.clusterUrl}", configuration = ConfluentConfig.class)
public interface ConfluentClient {

    @PostMapping("/kafka/v3/clusters/{cluster-id}/topics")
    JsonNode createTopic(@PathVariable("cluster-id") String custerId, @RequestBody TopicRequestBody body);

    @PostMapping("/kafka/v3/clusters/{cluster_id}/topics/{topic_name}/records")
    JsonNode produceRecords(@PathVariable("cluster_id") String custerId,@PathVariable("topic_name") String topicName, @RequestBody JsonNode body);

}

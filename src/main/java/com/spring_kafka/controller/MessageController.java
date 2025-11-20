package com.spring_kafka.controller;

import com.spring_kafka.constants.SpringKafkaConstants;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SpringKafkaConstants.BASE_PATH)
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody String requestBody){
        kafkaTemplate.send(SpringKafkaConstants.KAFKA_TOPIC, requestBody);
    }
}

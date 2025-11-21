package com.spring_kafka.controller;

import com.spring_kafka.constants.SpringKafkaConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SpringKafkaConstants.BASE_PATH)
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody String requestBody){
        LOGGER.info(String.format("MESSAGE SENT: %s", requestBody));
        kafkaTemplate.send(SpringKafkaConstants.KAFKA_TOPIC, requestBody);
    }
}

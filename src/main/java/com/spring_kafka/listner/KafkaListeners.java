package com.spring_kafka.listner;

import com.spring_kafka.constants.SpringKafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = SpringKafkaConstants.KAFKA_TOPIC,
            groupId = SpringKafkaConstants.GROUP_ID
    )
    void listener(String data) {
        System.out.println("Listener received data: " + data + " ");
    }

}

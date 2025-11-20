package com.spring_kafka.config;

import com.spring_kafka.constants.SpringKafkaConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {


    @Bean
    public NewTopic topicBuilder(){
        return TopicBuilder.name(SpringKafkaConstants.KAFKA_TOPIC).build();
    }


}

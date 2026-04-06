package com.spring_kafka;

import com.spring_kafka.constants.SpringKafkaConstants;
import org.apache.kafka.common.internals.Topic;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafkaApplication {

	public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class, args);
	}

    @Bean
     CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
        return args -> {
            for(int i=0; i<100; i++){
                kafkaTemplate.send(SpringKafkaConstants.KAFKA_TOPIC, "hello kafka 124 " + i);
            }
        };
    }

}

package hnt.spring.kafka.service;

import hnt.spring.kafka.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;


@Service
public class KafkaMessageListener {
    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class.getName());

//    @KafkaListener(topics = "kafka-topic-002", groupId = "group-1")
//    public void consume1(String message) {
//        logger.info("Consumer1 consume message {}", message);
//    }

//    @KafkaListener(topics = "kafka-topic-002", groupId = "group-1")
//    public void consume2(String message) {
//        logger.info("Consumer2 consume message {}", message);
//    }
//
//    @KafkaListener(topics = "kafka-topic-002", groupId = "group-1")
//    public void consume3(String message) {
//        logger.info("Consumer3 consume message {}", message);
//    }

    @KafkaListener(topics = "kafka-topic-003", groupId = "group-1")
    public void consume(Customer customer) {
        logger.info("Consumer1 consume message {}", customer.toString());
    }
}

package hnt.spring.kafka.service;

import hnt.spring.kafka.dto.CustomerAvro;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaMessageListener {
    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class.getName());
    public static Integer retryCount = 0;
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

//    @RetryableTopic(
//            attempts = "4",
//            backoff = @Backoff(delay = 3000,multiplier = 1.5, maxDelay = 15000),
//            exclude = {NullPointerException.class, RuntimeException.class})
//    @KafkaListener(topics = "kafka-topic-003", groupId = "group-1")
//    public void consume(Customer customer) {
//        logger.info("retry count : " + retryCount);
//        retryCount++;
//        if (customer.getName().equals("error")) {
//            throw new RuntimeException("Error");
//        }
//        logger.info("Consumer1 consume message {}", customer);
//    }
//
//    @DltHandler
//    public void listenDeadLetterTopic(Customer customer) {
//        logger.info("DTL receive message {}", customer);
//    }

    @KafkaListener(topics = "kafka-topic-avro", groupId = "group-1")
    public void read(ConsumerRecord<String, CustomerAvro> consumerRecord) {
        String key = consumerRecord.key();
        CustomerAvro customerAvro = consumerRecord.value();
        logger.info("Avro message received for key : {} value : {}" , key, customerAvro.toString());
    }
}

package hnt.spring.kafka.service;

import hnt.spring.kafka.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaMessagePublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("kafka-topic-002", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Message sent successfully with offset [" + result.getRecordMetadata().offset() + "]"
                        + " in partition [" + result.getRecordMetadata().partition() + "]");
            } else {
                System.out.println("Message sent with error [" + ex.getMessage() + "]");
            }
        });
    }

    public void sendEventToTopic(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("kafka-topic-003", customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Object " + customer.toString() + " sent successfully with offset [" + result.getRecordMetadata().offset() + "]"
                            + " in partition [" + result.getRecordMetadata().partition() + "]");
                } else {
                    System.out.println("CustomerDTO sent with error [" + ex.getMessage() + "]");
                }
            });
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

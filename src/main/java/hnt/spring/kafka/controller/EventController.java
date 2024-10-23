package hnt.spring.kafka.controller;

import hnt.spring.kafka.dto.Customer;
import hnt.spring.kafka.dto.CustomerAvro;
import hnt.spring.kafka.service.KafkaMessagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produce-app")
@RequiredArgsConstructor
public class EventController {

    private final KafkaMessagePublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try {
            publisher.sendMessageToTopic(message);
            return ResponseEntity.ok("message published successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/publish")
    public void sendEvents(@RequestBody Customer customer) {
        publisher.sendEventToTopic(customer);
    }

    @PostMapping("/avro/publish")
    public void sendEvents(@RequestBody CustomerAvro customer) {
        publisher.sendEventToTopicAvro(customer);
    }
}

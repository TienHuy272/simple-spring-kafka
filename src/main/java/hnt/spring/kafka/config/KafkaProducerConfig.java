package hnt.spring.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic newTopic() {
        return new NewTopic("kafka-topic-003", 5, (short) 1);
    }
}

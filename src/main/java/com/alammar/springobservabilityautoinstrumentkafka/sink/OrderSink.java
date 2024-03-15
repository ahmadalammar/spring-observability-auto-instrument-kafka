package com.alammar.springobservabilityautoinstrumentkafka.sink;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderSink {
    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(ConsumerRecord<String, String> data) {
        System.out.println("Received message: " + data.value());
    }
}

package com.alammar.springobservabilityautoinstrumentkafka.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping
    public String testUUID() {

        String uuid = UUID.randomUUID().toString();
        kafkaTemplate.send("my-topic", uuid);

        return uuid;
    }
}

package com.southdragon.producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){
        kafkaTemplate.send("my-topic", message);
        return "Message sent: " + message;
    }
}

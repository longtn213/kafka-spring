//package com.southdragon.producer.controller;
//
//import com.southdragon.producer.RiderLocation;
//import lombok.RequiredArgsConstructor;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
//public class KafkaProducerController {
//
//    private final KafkaTemplate<String, RiderLocation> kafkaTemplate;
//
//    @PostMapping("/send")
//    public String sendMessage(@RequestParam String message){
//        RiderLocation riderLocation = new RiderLocation("rider123", 123.2, 34.23);
//        kafkaTemplate.send("my-topic-1", riderLocation);
//        return "Message sent: " + riderLocation.getRiderId();
//    }
//}

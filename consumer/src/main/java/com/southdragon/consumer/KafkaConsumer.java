//package com.southdragon.consumer;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class KafkaConsumer {
//    @KafkaListener(topics = "my-topic", groupId = "my-new-group")
//    public void listen1(String message){
//        System.out.println("Received Message: " + message);
//    }
//
//    @KafkaListener(topics = "my-topic", groupId = "my-new-group-new")
//    public void listen2(String message){
//        System.out.println("Received Message 2: " + message);
//    }
//
//    @KafkaListener(topics = "my-topic-1", groupId = "my-new-group-rider")
//    public void listenRiderLocation(RiderLocation location){
//        System.out.println("Received Message 2: " + location.getRiderId()
//                + " : " + location.getLatitude() + " : " + location.getLongitude());
//    }
//}

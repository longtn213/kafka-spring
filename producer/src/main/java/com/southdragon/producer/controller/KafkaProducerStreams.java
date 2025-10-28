package com.southdragon.producer.controller;

import com.southdragon.producer.RiderLocation;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import java.util.Random;
import java.util.function.Supplier;


@RequiredArgsConstructor
@Configuration
public class KafkaProducerStreams {

    @Bean
    public Supplier<RiderLocation> sendRiderLocation() {
        Random random = new Random();
        return () -> {
            String riderId = "rider-" + random.nextInt(20);
            RiderLocation location = new RiderLocation(riderId, random.nextDouble(), random.nextDouble());
            System.out.println("Sending: "+ location.getRiderId());
            return location;
        };
    }

    @Bean
    public Supplier<Message<String>> sendRiderStatus() {
        Random random = new Random();
        return () -> {
            String riderId = "rider-" + random.nextInt(20);
            String status = random.nextBoolean() ? "ride started" : "ride ended";
            String payload = riderId + " : " + status;
            System.out.println("📤 Sending RiderStatus: " + payload);

            return MessageBuilder.withPayload(payload)
                    .setHeader(KafkaHeaders.KEY, riderId.getBytes()) // ✅ dùng MESSAGE_KEY thay vì KEY + String
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN_VALUE)
                    .build();
        };
    }

}

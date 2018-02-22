package com.vitz.springbootkafkaproducerconsumer.service;

import com.vitz.springbootkafkaproducerconsumer.model.Person;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by vsinha on 2/21/2018.
 */

@Component
public class MessageListener {

    @KafkaListener(topics = "${message.topic.name}")
    public void listen(String message) {
        System.out.println("Received string messasge: " + message);
    }

    @KafkaListener(topics = "${person.topic.name}", containerFactory = "personKafkaListenerContainerFactory")
    public void greetingListener(Person person) {
        System.out.println("Recieved person message: " + person.toString());
    }

}

package com.vitz.springbootkafkaproducerconsumer.service;

import com.vitz.springbootkafkaproducerconsumer.model.Person;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by vsinha on 2/21/2018.
 */

@Component
public class MessageProducer {

    @Value(value = "${message.topic.name}")
    private String messageTopicName;

    @Value(value = "${person.topic.name}")
    private String personTopicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Person> personKafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send(messageTopicName, msg);
    }

    public void sendPersonMessage(Person person) {
        ProducerRecord<String, Person> record = new ProducerRecord<String, Person>(personTopicName, person);
        personKafkaTemplate.send(record);
    }
}

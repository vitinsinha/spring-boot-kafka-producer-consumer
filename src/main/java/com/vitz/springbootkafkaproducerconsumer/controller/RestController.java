package com.vitz.springbootkafkaproducerconsumer.controller;

import com.vitz.springbootkafkaproducerconsumer.model.Person;
import com.vitz.springbootkafkaproducerconsumer.service.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by vsinha on 2/21/2018.
 */

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/sendMessage")
public class RestController {

    @Autowired
    private MessageProducer messageProducer;

    @RequestMapping(method = RequestMethod.GET)
    public void sendMessage(@RequestParam(value="message", defaultValue="Test") String message) {
        messageProducer.sendMessage(message);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void sendMessage(@RequestBody Person person) {
        messageProducer.sendPersonMessage(person);
    }


}

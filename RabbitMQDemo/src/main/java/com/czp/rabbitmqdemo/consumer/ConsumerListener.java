package com.czp.rabbitmqdemo.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "czpQueue1110"),
            exchange = @Exchange(name = "czpExchange1110"),
            key = {"red", "blue"}
    ))
    public void czpListener (String msg) {
        System.out.println(msg);
    }
}

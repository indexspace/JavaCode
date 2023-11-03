package com.czp.rabbitmqdemo.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {

    @RabbitListener(queues = "hello.queue1")
    public void listenQueue1(String message) {
        System.out.println("queue1=" + message);
    }

    @RabbitListener(queues = "hello.queue2")
    public void listenQueue2(String message) {
        System.out.println("queue2=" + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "hello.queue3"),
            exchange = @Exchange(name = "amq.fanout", type = ExchangeTypes.FANOUT)
    ))
    public void listenQueue3(String message) {
        System.out.println("queue3=" + message);
    }

    @RabbitListener(queues = "myQueue")
    public void listenQueue4(String message) {
        System.out.println("myQueue=" + message);
    }
}

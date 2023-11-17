package com.czp.rabbitmqdemo.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("myFanout");
    }

    @Bean
    public Queue queue() {
        return new Queue("myQueue");
    }
//方法一
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(fanoutExchange());
    }
// 方法二
//    @Bean
//    public Binding binding(Queue queue, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(queue).to(fanoutExchange);
//    }
}

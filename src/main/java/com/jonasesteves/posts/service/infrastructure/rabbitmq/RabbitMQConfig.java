package com.jonasesteves.posts.service.infrastructure.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {
    public static final String FANOUT_EXCHANGE_NAME = "posts-service.post-created.v1.e";
    public static final String ROOT_PRICE_DEFINITION = "posts-service.post-processing-result.v1";
    public static final String QUEUE_PRICE_DEFINITION = ROOT_PRICE_DEFINITION + ".q";
    public static final String DEAD_LETTER_QUEUE_PRICE_DEFINITION = ROOT_PRICE_DEFINITION + ".dlq";

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public FanoutExchange exchange() {
        return ExchangeBuilder.fanoutExchange(FANOUT_EXCHANGE_NAME).build();
    }

    @Bean
    public Queue queuePostsPriceDefinition() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "");
        args.put("x-dead-letter-routing-key", DEAD_LETTER_QUEUE_PRICE_DEFINITION);
        return QueueBuilder.durable(QUEUE_PRICE_DEFINITION).withArguments(args).build();
    }

    @Bean
    public Queue deadLetterQueuePostsPriceDefinition() {
        return QueueBuilder.durable(DEAD_LETTER_QUEUE_PRICE_DEFINITION).build();
    }

    @Bean
    public Jackson2JsonMessageConverter  jackson2JsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}

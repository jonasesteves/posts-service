package com.jonasesteves.posts.service.infrastructure.rabbitmq;

import com.jonasesteves.posts.service.api.domain.PostDataResponse;
import com.jonasesteves.posts.service.domain.service.PostService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.jonasesteves.posts.service.infrastructure.rabbitmq.RabbitMQConfig.QUEUE_PRICE_DEFINITION;

@Component
public class RabbitMQListener {

    private final PostService  postService;

    public RabbitMQListener(PostService postService) {
        this.postService = postService;
    }

    @RabbitListener(queues = QUEUE_PRICE_DEFINITION)
    public void receiveMessageWithPrice(@Payload PostDataResponse postDataResponse) {
        postService.postPriceUpdate(postDataResponse);
    }
}

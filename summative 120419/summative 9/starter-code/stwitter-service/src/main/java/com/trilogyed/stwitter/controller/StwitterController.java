package com.trilogyed.stwitter.controller;
import com.trilogyed.stwitter.service.ServiceLayer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


@RestController
@RefreshScope
@CacheConfig(cacheNames = {"posts"})

public class StwitterController {

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.commentviewmodel.controller";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    ServiceLayer service;

    public StwitterController(RabbitTemplate rabbitTemplate, ServiceLayer service) {

        this.rabbitTemplate = rabbitTemplate;
        this.service = service;

    }


}
package com.mycomp.mq.demo.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {"MyQueue"})
    public void receive(@Payload String fileBody) {
        System.out.println("Message " + fileBody);
    }
}
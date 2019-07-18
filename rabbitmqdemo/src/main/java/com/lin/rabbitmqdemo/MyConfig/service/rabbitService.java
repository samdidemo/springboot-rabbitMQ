package com.lin.rabbitmqdemo.MyConfig.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class rabbitService {
    @RabbitListener(queues = "lin")
    public void recieve(Map<String, Object> map){
        System.out.println(map.toString());
    }
}

package com.lin.rabbitmqdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqdemoApplicationTests {

    @Autowired
    RabbitTemplate template;

    /**
     * 往交换机里面发送消息
     */
    @Test
    public void contextLoads() {
        Map<String,Object> map=new HashMap<>();
        map.put("msg","傻逼");
        map.put("name","linyongbin");
        template.convertAndSend("linyongbin","lin",map);
    }

    /**
     * 从消息队列中获取消息，进行消费
     */
    @Test
    public void test(){
        Object o=template.receiveAndConvert("lin");
        System.out.println(o.toString());
    }


}

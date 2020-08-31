package com.example.zuul.receiver;

import com.example.zuul.entity.LogBean;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class Receiver {
    @RabbitListener(queues = "logDigestDirectQueue")
    public void handler(String msg) {
        System.out.println("handler >>>" + msg);
    }
}

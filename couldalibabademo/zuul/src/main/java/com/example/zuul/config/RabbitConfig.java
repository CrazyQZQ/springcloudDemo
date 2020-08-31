package com.example.zuul.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitConfig {
    private final String DIRECNAME = "direct";

    @Bean
    Queue queue() {
        log.info("建立消息队列》》》》");
        return new Queue("logDigestDirectQueue");
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECNAME,true,false);
    }

    @Bean
    Binding binding(){
        log.info("绑定消息队列》》》》");
        return BindingBuilder.bind(queue()).to(directExchange()).with("logDigestDirectQueue");
    }
}

package com.example.zuul;

import com.example.zuul.filter.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean
    MyFilter initMyFilter(){
        InputStream in;
        return new MyFilter();
    }
}

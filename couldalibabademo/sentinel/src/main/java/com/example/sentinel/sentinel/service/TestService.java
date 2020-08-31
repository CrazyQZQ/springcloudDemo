package com.example.sentinel.sentinel.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("nacos-client")
public interface TestService {
    @GetMapping("/hello")
    String test();
}

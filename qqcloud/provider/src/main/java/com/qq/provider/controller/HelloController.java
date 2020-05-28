package com.qq.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 秦强
 * @version 1.0
 * @date 2020/5/28 20:06
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    private Integer port;
    @GetMapping("/hello")
    public String hello() {
        return "hello provider:" + port;
    }
}

package com.example.sentinel.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.sentinel.sentinel.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaojing
 */
@RestController
public class SentinelTestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    TestService testService;

    @GetMapping(value = "/hello")
    @SentinelResource("resource")
    public String hello() {
        return "Hello";
    }

    @GetMapping(value = "/aa")
    @SentinelResource("aa")
    public String aa(int b, int a) {
        return "Hello test";
    }

    @GetMapping(value = "/test")
    public String test1() {
        return "Hello test";
    }

    @GetMapping(value = "/template")
    public String client() {
        return restTemplate.getForObject("http://www.taobao.com/test", String.class);
    }

    @GetMapping(value = "/testFeign")
    public String testFeign(){
        return testService.test();
    }
}

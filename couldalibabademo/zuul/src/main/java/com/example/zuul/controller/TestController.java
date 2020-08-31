package com.example.zuul.controller;

import com.example.zuul.entity.LogBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class TestController {
    @GetMapping("/test")
    public String test(){
        LogBean logBean = new LogBean();
        logBean.setMethodName("test");
        logBean.setTime(new Date());
        log.info("test >> {}"+logBean);

        return "test";
    }
}

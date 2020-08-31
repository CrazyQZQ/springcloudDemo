package com.example.zuul.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LogBean {
    private String methodName;
    private Date time;

}

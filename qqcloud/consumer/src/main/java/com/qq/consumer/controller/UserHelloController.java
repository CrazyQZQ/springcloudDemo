package com.qq.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author 秦强
 * @version 1.0
 * @date 2020/5/28 20:18
 */
@RestController
public class UserHelloController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/userHello")
    public String userHello() {
        HttpURLConnection con = null;
        try {
            URL url = new URL("http://localhost:1113/hello");
            con = (HttpURLConnection)url.openConnection();
            if(con.getResponseCode() == 200){
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String s = br.readLine();
                br.close();
                return s;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
    int count = 0;
    @GetMapping("/userHello2")
    public String userHello2() {
        // 根据服务名获取服务，可能有多个实例
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get((count++) % list.size());
        String host = instance.getHost();
        int port = instance.getPort();
        StringBuffer sb = new StringBuffer();
        sb.append("http://")
                .append(host).append(":").append(port).append("/hello");
        HttpURLConnection con = null;
        try {
            URL url = new URL(sb.toString());
            con = (HttpURLConnection)url.openConnection();
            if(con.getResponseCode() == 200){
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String s = br.readLine();
                br.close();
                return host+":"+port+"/"+s;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}

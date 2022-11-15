package com.example.servicecompany.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
public class MainController {

    @Value("${user.mail}")
    private String ownerMail;
    @Value("${server.port}")
    private String serverPort;

    @Value("${server.test.param}")
    private String testParametre;

    @GetMapping("/global-config")
    public Map<String, Object> globalConfiguration(){
        Map<String, Object> configs = new HashMap<>();
        configs.put("owner-mail", ownerMail);
        configs.put("thread-name", Thread.currentThread().getName());
        return configs;
    }

    @GetMapping("/server-config")
    public Map<String, Object> serverConfiguration(){
        Map<String, Object> configs = new HashMap<>();
        configs.put("owner-mail", ownerMail);
        configs.put("server-port", serverPort);
        configs.put("test-parametre", testParametre);
        configs.put("thread-name", Thread.currentThread().getName());
        return configs;
    }

}

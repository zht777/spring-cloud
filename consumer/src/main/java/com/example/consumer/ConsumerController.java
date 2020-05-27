package com.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/api/v1/demo/get")
    public String consumer(){
        return this.restTemplate.getForObject("http://localhost:6060/producer/demo", String.class);
    }
}

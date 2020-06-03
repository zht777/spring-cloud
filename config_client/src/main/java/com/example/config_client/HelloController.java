package com.example.config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RefreshScope
public class HelloController {
    @Value("${info.profile:error}")
    private String profile;

    @RequestMapping("/info")
    public Mono<String> from() {
        return Mono.justOrEmpty(profile);
    }
}

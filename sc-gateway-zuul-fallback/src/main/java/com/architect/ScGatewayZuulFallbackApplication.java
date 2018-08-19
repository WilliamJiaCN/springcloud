package com.architect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@SpringBootApplication
public class ScGatewayZuulFallbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScGatewayZuulFallbackApplication.class, args);
    }
}

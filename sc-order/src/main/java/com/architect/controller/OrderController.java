package com.architect.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author william
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.getUserById.url}")
    private String userGetUserByIdUrl;

    @GetMapping("/getUserById/{id}")
    public Object getUserById(@PathVariable Long id) {
        String url = userGetUserByIdUrl + id;
        return restTemplate.getForEntity(url, Object.class);
    }
}
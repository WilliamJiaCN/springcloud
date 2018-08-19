package com.architect.controller;

import com.architect.api.dto.User;
import com.architect.service.HystrixOrderService;
import com.architect.command.OrderServiceCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wenxiong.jia
 * @since 2018/8/7
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixOrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HystrixOrderService hystrixOrderService;

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        OrderServiceCommand command = new OrderServiceCommand("orderGroup", restTemplate, id);
        User user = command.execute();
        return user;
    }

    @GetMapping("/getUserByIdWithHystrixAnnotation/{id}")
    public User getUserByIdWithHystrixAnnotation(@PathVariable Long id) {
        return hystrixOrderService.getUserById(id);
    }
}

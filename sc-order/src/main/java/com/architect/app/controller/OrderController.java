package com.architect.app.controller;

import com.architect.api.dto.User;
import com.architect.app.feign.UserService;
import com.architect.app.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author william
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @Value("${user.getUserById.url}")
    private String userGetUserByIdUrl;

    @GetMapping("/getUserById/{id}")
    public Object getUserById(@PathVariable Long id) {
        String url = userGetUserByIdUrl + id;
        return restTemplate.getForEntity(url, Object.class);
    }

    @GetMapping("/getUserByIdWithFeign/{id}")
    public Object getUserByIdWithFeign(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getUserList")
    public List<User> getUserList() {
        return userService.getUserList();
    }

//    @GetMapping("/getUserByIdWithHystrix/{id}")
//    public Object getUserByIdWithHystrix(@PathVariable Long id) {
//        OrderServiceCommand command = new OrderServiceCommand("orderGroup", userService, id);
//        return command.execute();
//    }
//
//    @GetMapping("/getUserByIdWithHystrixAnnotation/{id}")
//    public Object getUserByIdWithHystrixAnnotation(@PathVariable Long id) {
//        return orderService.getUserById(id);
//    }
}
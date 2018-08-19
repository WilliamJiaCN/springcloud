package com.architect.controller;

import com.architect.feign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author william
 */
@Slf4j
@RestController
@RequestMapping("/stream")
public class HystrixStreamController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserByIdWithFeign/{id}")
    public Object getUserByIdWithFeign(@PathVariable Long id) {
        log.info("===========调用用户服务,用户ID:{}=============", id);
        return userService.getUserById(id);
    }
}
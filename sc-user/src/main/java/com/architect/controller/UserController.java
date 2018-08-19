package com.architect.controller;

import com.architect.api.dto.User;
import com.architect.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author william
 * @since 2018/7/27
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getById/{id}")
    public User getUserById(@PathVariable Long id) {
        log.info("请求参数：{}", id);
        return userService.getById(id);
    }

    @GetMapping("/getUserList")
    public List<User> getUserList() {
        List<User> users = userService.getList();
        log.info("用户信息列表：{}", users);
        if (CollectionUtils.isEmpty(users)) {
            return new ArrayList<>();
        }
        return users;
    }
}
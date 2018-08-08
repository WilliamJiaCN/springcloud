package com.architect.app.service.impl;

import com.architect.api.dto.User;
import com.architect.app.feign.UserService;
import com.architect.app.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wenxiong.jia
 * @since 2018/8/7
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private UserService userService;

    @Override
    public User getUserById(Long id) {
        log.info("===========调用用户服务============");
        long startTime = System.currentTimeMillis();
        User user = userService.getUserById(id);
        log.info("调用用户服务耗时：{}", System.currentTimeMillis() - startTime);
        return user;
    }
}

package com.architect.service.impl;

import com.architect.api.dto.User;
import com.architect.service.HystrixOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wenxiong.jia
 * @since 2018/8/7
 */
@Slf4j
@Service
public class HystrixOrderServiceImpl implements HystrixOrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "defaultUser", groupKey = "orderGroup", threadPoolKey = "orderThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "6"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "1")
            })
    public User getUserById(Long id) {
        log.info("线程名称:{}", Thread.currentThread().getName());
        log.info("===========调用用户服务,用户ID:{}=============", id);
        return restTemplate.getForObject("http://sc-user/user/getById/" + id, User.class);
    }

    public User defaultUser(Long id) {
        return new User();
    }
}

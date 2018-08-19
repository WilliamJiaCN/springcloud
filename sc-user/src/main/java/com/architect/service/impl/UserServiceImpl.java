package com.architect.service.impl;

import com.architect.api.dto.User;
import com.architect.mapper.UserMapper;
import com.architect.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wenxiong.jia
 * @since 2018/7/27
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private static Map<Long, User> userInfos = new HashMap<>();

    static {
        User user = new User();
        user.setId(1L);
        user.setAge(28);
        user.setName("William");
        user.setPhone("15353714844");
        user.setAddress("北京市昌平区");
        userInfos.put(1L, user);
        userInfos.put(2L, user);
        userInfos.put(3L, user);
    }
//    @Autowired
//    private UserMapper userMapper;

    @Override
    public User findByPrimaryKey(Long id) {
        // 测试异常服务熔断
        if (id == 10) {
            throw new NullPointerException();
        }
//        long startTime = System.currentTimeMillis();
//        // 测试超时服务降级
//        int sleepTime = new Random().nextInt(3000);
//        log.info("sleep time:{}", sleepTime);
//        try {
//            // 测试限流
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        User user = userMapper.queryByPrimaryKey(id);
//        log.info("方法执行耗时：{}", System.currentTimeMillis() - startTime);
        return new User();
    }

    @Override
    public List<User> getList() {
//        return userMapper.queryList();
        return null;
    }

    @Override
    public User getById(Long id) {
        return userInfos.get(id);
    }
}

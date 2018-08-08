package com.architect.app.feign.impl;

import com.architect.api.dto.User;
import com.architect.app.feign.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenxiong.jia
 * @since 2018/8/8
 */
@Service
public class DefaultUserServiceImpl implements UserService {
    @Override
    public User getUserById(Long id) {
        return new User();
    }

    @Override
    public List<User> getUserList() {
        return new ArrayList<>();
    }
}

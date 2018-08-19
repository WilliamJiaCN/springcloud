package com.architect.feign.impl;

import com.architect.api.dto.User;
import com.architect.feign.UserService;
import org.springframework.stereotype.Service;

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
}

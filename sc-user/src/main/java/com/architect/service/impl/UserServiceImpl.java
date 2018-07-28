package com.architect.service.impl;

import com.architect.bean.User;
import com.architect.mapper.UserMapper;
import com.architect.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wenxiong.jia
 * @since 2018/7/27
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByPrimaryKey(Long id) {
        return userMapper.queryByPrimaryKey(id);
    }
}

package com.architect.service;

import com.architect.api.dto.User;

/**
 * @author wenxiong.jia
 * @since 2018/8/7
 */
public interface HystrixOrderService {
    User getUserById(Long id);
}

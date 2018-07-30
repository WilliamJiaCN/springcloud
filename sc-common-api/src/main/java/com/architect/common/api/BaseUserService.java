package com.architect.common.api;

import com.architect.api.dto.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author wenxiong.jia
 * @since 2018/7/30
 */
public interface BaseUserService {
    /**
     * 获取用户信息列表
     *
     * @return 用户信息列表
     */
    @GetMapping("/user/getUserList")
    List<User> getUserList();
}

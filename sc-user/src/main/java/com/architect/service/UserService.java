package com.architect.service;

import com.architect.bean.User;

/**
 * @author william
 * @since 2018/7/27
 */
public interface UserService {
    /**
     * 根据主键查询用户信息
     *
     * @param id 主键
     * @return 用户信息
     */
    User findByPrimaryKey(Long id);
}

package com.architect.feign;

import com.architect.api.dto.User;
import com.architect.feign.impl.DefaultUserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wenxiong.jia
 * @since 2018/7/30
 */
@FeignClient(name = "sc-user", fallback = DefaultUserServiceImpl.class)
public interface UserService {

    /**
     * 根据ID获取用户信息
     *
     * @param id ID
     * @return 用户信息
     */
    @GetMapping("/user/getById/{id}")
    User getUserById(@PathVariable("id") Long id);
}

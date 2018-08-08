package com.architect.command;

import com.architect.api.dto.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

/**
 * @author wenxiong.jia
 * @since 2018/8/7
 */
@Slf4j
public class OrderServiceCommand extends HystrixCommand<User> {
    private RestTemplate restTemplate;
    private Long id;

    public OrderServiceCommand(String commandGroupKey, RestTemplate restTemplate, Long id) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        log.info("===========调用用户服务============");
        return restTemplate.getForObject("http://sc-user/user/getById/" + id, User.class);
    }

    @Override
    protected User getFallback() {
        User user = new User();
        user.setId(-1L);
        user.setName("降级用户");
        return user;
    }
}

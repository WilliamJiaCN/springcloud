package com.architect.controller;

import com.architect.api.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wenxiong.jia
 * @since 2018/8/12
 */
@RestController("/zuul")
public class AggregationController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/greet")
    public Object greet() throws Exception {
        return "Hello Zuul";
    }

    @GetMapping("/aggregate/{id}")
    public Object findById(@PathVariable Long id) {
        String msg = restTemplate.getForObject("http://sc-order/order/greet", String.class);
        User user = restTemplate.getForObject("http://sc-user/user/getById/" + id, User.class);
        return msg + (user == null ? "" : user.getName());
    }
}

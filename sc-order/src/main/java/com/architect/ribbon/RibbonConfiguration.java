package com.architect.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该类为Ribbon的配置类
 * 注意：该类不应该在主应用程序上下文的@ComponentScan中
 *
 * @author wenxiong.jia
 * @since 2018/7/30
 */
@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule loadBalanceRule() {
        return new RoundRobinRule();
    }
}

package com.architect.config;

import com.architect.ribbon.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 使用RibbonClient，为特定name的Ribbon Client自定义配置。
 * 使用@RibbonClient的configuration属性，指定Ribbon的配置类。
 *
 * @author wenxiong.jia
 * @since 2018/7/30
 */
@Configuration
@RibbonClient(name = "sc-user", configuration = RibbonConfiguration.class)
public class ProviderUserConfiguration {
}

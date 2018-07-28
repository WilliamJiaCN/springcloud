package com.architect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author william
 * @since 2018/7/27
 */
@SpringBootApplication
@EnableEurekaClient
public class ScOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScOrderApplication.class, args);
	}
}

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
public class ScUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScUserApplication.class, args);
	}
}

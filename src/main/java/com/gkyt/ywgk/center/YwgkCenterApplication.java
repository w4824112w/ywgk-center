package com.gkyt.ywgk.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author hk
 *
 */
@EnableEurekaServer
// 启动一个服务注册中心提供给其他应用进行对话
@SpringBootApplication
public class YwgkCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(YwgkCenterApplication.class, args);
	}
}

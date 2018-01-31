package org.spring.my.eureka.service.discovery2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient           //通过该注解，实现服务发现，注册
@SpringBootApplication
public class EurekaClientApplication 
{
	 public static void main(String[] args) {
	        SpringApplication.run(EurekaClientApplication.class, args);
	    }
}

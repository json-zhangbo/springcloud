package org.spring.my.eureka.service.feign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard 
@EnableCircuitBreaker
@EnableHystrix
//开启Feign功能
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ServiceClient02BootStarp {
	 public static void main(String[] args) {
	        SpringApplication.run(ServiceClient02BootStarp.class, args);
	    }
}

package org.spring.my.cloud.zull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ApirouteserviceApplication {
	 public static void main(String[] args) {
	        SpringApplication.run(ApirouteserviceApplication.class, args);
	    }
}

package org.spring.my.eureka.service.ribbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableHystrixDashboard  
//开启断路器功能，表明使用断路器。
@EnableCircuitBreaker
//@EnableDiscoveryClient
@EnableEurekaClient
//@RibbonClients
@SpringBootApplication
public class ServiceClient01BootStarp {
	   //开启软均衡负载
	@Autowired
    private RestTemplateBuilder builder;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceClient01BootStarp.class, args);
    }
}

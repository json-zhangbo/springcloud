package org.spring.my.eureka.service.ribbon.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class CalculatorService {
	    @Autowired
	    private RestTemplate restTemplate;
	    
	    @Autowired
	    private LoadBalancerClient loadBalancerClient;
	    
	    @HystrixCommand(fallbackMethod="addServiceToFallback")
	    public int addService(int a, int b){
	    	ServiceInstance serviceInstance = this.loadBalancerClient.choose("CalculatorServer");
	        System.out.println("服务主机：" + serviceInstance.getHost());
	        System.out.println("服务端口：" + serviceInstance.getPort());
         
	        String reqURL = "http://CalculatorServer/add?a=" + a + "&b=" + b;
	        return restTemplate.getForObject(reqURL, Integer.class);
	       // return restTemplate.getForEntity(reqURL, Integer.class).getBody();
	    }
	 public int addServiceToFallback(int aa, int bb){
	        return -999;
	    }
}

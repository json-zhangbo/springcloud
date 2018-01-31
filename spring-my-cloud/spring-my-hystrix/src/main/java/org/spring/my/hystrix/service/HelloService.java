package org.spring.my.hystrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.spring.my.hystrix.exption.BadRequestException;
@Service
public class HelloService {
	@Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "helloFailback")
    public String hello() {
      return  restTemplate.getForObject("http://client-service/hello",String.class);
    }

    public String helloFailback(){
        System.out.println("----执行降级策略----");
        return "----执行降级策略----";
    }

    @HystrixCommand(fallbackMethod = "handlerFailback", ignoreExceptions = {BadRequestException.class})
    public String handler() {
        throw new RuntimeException("运行时异常");
    }

    public String handlerFailback(Throwable e){
        System.err.println("异常信息:"+ e.getMessage());
        return "获取异常信息并可以做具体的降级处理";
    }

   /* @HystrixCommand(
            commandKey = "actionKey",
            commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", KEY value = "8000" VALUE)},
            fallbackMethod = "actionFailback")
    public String action() {
       return restTemplate.getForObject("http://client-service/action",String.class);
    }*/

    public String actionFailback(){
        System.out.println("----执行降级策略----");
        return "----执行降级策略----";
    }

	public String action() {
		// TODO Auto-generated method stub
		return "12321";
	}
}

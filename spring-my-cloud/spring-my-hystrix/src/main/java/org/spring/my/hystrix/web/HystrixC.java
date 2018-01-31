package org.spring.my.hystrix.web;

import org.spring.my.hystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixC {
	@Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public String hello(){
        return helloService.hello();
    }

    @RequestMapping(value = "/hystrix-handler",method = {RequestMethod.GET})
    public String handler(){
        return helloService.handler();
    }

    @RequestMapping(value = "/hystrix-action",method = {RequestMethod.GET})
    public String action(){
        return helloService.action();
    }
}

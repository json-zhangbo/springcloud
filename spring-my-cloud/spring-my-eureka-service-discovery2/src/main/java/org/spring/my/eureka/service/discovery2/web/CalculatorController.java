package org.spring.my.eureka.service.discovery2.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculatorController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private DiscoveryClient client;
    /***
     * .在微服务中参数增加@RequestBody
		@RequestMapping(value = "/create", method = RequestMethod.POST)
		    public void create(@RequestBody String info) {
		
		    }
           这样info得到的就是json格式
     * 
     * @param a
     * @param b
     * @return
     */
    @RequestMapping(value="/add", produces = { "application/json;charset=UTF-8" })
    public int add(int a, int b){
        //加运算
        int result = a + b;
        //输出服务信息
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("uri={}，serviceId={}，result={}", instance.getUri(), instance.getServiceId(), result);
        //返回结果
        return result;
    }
}
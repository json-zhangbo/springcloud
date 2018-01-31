package org.spring.my.eureka.service.feign.web;
import org.spring.my.eureka.service.feign.service.CalculatorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 服务调用方
 * Created by json<http://jadyer.cn/> on 2018/1/13 18:23.
 */
@RestController
@RequestMapping("/demo/feign")
public class ConsumerController {
	  @Resource
	    private CalculatorService calculatorService;

	    @RequestMapping("/toadd")
	    int toadd(int a, int b){
	        return calculatorService.myadd(a, b);
	    }
}

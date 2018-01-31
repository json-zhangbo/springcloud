package org.spring.my.eureka.service.ribbon.web;
import org.spring.my.eureka.service.ribbon.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务调用方
 * Created by json<http://jadyer.cn/> on 2018/1/16 11:04.
 */
@RestController
@RequestMapping("/demo/ribbon")
public class ConsumerController {
	    @Autowired
	    private CalculatorService calculatorService;

	    @RequestMapping("/toadd")
	    int toadd(@RequestParam("a") int a, @RequestParam("b") int b){
	        return calculatorService.addService(a, b);
	    }
}

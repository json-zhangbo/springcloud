package org.spring.my.hystrix.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {
	@Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/movie/{id}",method= RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "findByIdFailback")
    public User findById(@PathVariable Long id) {
        // http://localhost:7900/simple/
        // VIP virtual IP
        // HAProxy Heartbeat
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

    public User findByIdFailback(Long id) {
        User user = new User();
        user.setName("json");
        return user;
    }

}

package org.spring.my.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
@EnableHystrix
@EnableHystrixDashboard
public class DashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}

}
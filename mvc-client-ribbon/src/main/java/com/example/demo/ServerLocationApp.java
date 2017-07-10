package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
//@EnableDiscoveryClient
@RibbonClient(
		name = "mvc1-app",
		configuration = RibbonConfiguration.class)
public class ServerLocationApp {

	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/sayHi/{name}")
	public String sayHi(@PathVariable String name) {
		return restTemplate.getForObject(
				"http://mvc1-app/hi/"+name, String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerLocationApp.class, args);
	}
}
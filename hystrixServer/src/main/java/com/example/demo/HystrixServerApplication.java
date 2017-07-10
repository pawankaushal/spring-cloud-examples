package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableCircuitBreaker
@RestController
public class HystrixServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixServerApplication.class, args);
	}

	public int print2(){
		return 2;
	}
	@HystrixCommand(fallbackMethod="print2")
	@GetMapping("/circuit")
	public int sayHiToHystrix(){
		if(Math.random()>.5){
			throw new RuntimeException("Random Greater than .5");
		}
		return 1;
	}
}

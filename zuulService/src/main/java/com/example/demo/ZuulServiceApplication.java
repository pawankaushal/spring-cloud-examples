package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.zuul.ZuulFilter;

@SpringBootApplication
@EnableZuulProxy
@RestController
public class ZuulServiceApplication {
	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}

	@Bean
	public ZuulFilter getFilter(){
		return new MyZuulFilter();
	}
	@Autowired
	RestTemplate template;

	@GetMapping("/hizuul/{name}")
	public String callRemoteSvc(@PathVariable String name){
		return template.getForObject("http://localhost:8080/hi/"+name, String.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}
}

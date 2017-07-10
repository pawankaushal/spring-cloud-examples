package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import be.ordina.msdashboard.EnableMicroservicesDashboardServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMicroservicesDashboardServer
public class DashboardMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardMicroservicesApplication.class, args);
	}
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;
import com.netflix.loadbalancer.ServerListSubsetFilter;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

public class RibbonConfiguration {

	@Autowired
	IClientConfig ribbonClientConfig;

	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new WeightedResponseTimeRule();
	}

	@Bean
	public ILoadBalancer ribbonLB(IClientConfig config) {
		return new DynamicServerListLoadBalancer<>(config);
	}

	@Bean
	public ServerListFilter<Server> serverListFilter() {
		return new ServerListSubsetFilter<Server>();
	}
}

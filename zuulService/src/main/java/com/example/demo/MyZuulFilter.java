package com.example.demo;

import com.netflix.zuul.ZuulFilter;

public class MyZuulFilter extends ZuulFilter {
	@Override
	public Object run() {
		System.out.println("Custom Zuul Filter!!!!");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}

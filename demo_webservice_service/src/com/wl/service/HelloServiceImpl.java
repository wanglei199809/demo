package com.wl.service;

import javax.jws.WebService;

@WebService
public class HelloServiceImpl implements HelloService{
	public void sayHello(String name) {
		System.out.println("hello\t"+name);
	}
	public String sayGoodBay() {
		return "good bye !";
	}
}

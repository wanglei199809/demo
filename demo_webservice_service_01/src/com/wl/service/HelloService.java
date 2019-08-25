package com.wl.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService {
	
	@WebMethod
	public void sayHello(String name);
	
	@WebMethod
	public String sayGoodBay();
}

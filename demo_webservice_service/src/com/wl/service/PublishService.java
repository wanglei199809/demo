package com.wl.service;

import javax.xml.ws.Endpoint;

public class PublishService {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/hello", new HelloServiceImpl());
	}
}

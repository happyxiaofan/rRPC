package com.rhwayfun.rRPC.service.impl;

import com.rhwayfun.rRPC.service.DubboDemoService;

public class DubboDemoServiceImpl implements DubboDemoService {

	public String sayHello(String name) {
		return "hello " + name;
	}

}

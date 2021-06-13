package com.bwf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2Controller {
	
	
	@RequestMapping("show1")
	public void show1() {
		
		
		System.out.println("show1方法........");
		
	}

}

package com.bwf.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages= {"com.bwf.controller","com.bwf.config"})
public class StartApp {


	
	public static void main(String[] args) {
		
		
		System.out.println("����������.....................");
	
		
		SpringApplication.run(StartApp.class);
		
	}
	
	
}

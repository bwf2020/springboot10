package com.bwf.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages= "com.bwf.*")
@MapperScan(basePackages="com.bwf.mapper")
public class StartApp {



	public static void main(String[] args) {
		
		
		System.out.println("Æô¶¯·þÎñÆ÷.....................");
	
		
		SpringApplication.run(StartApp.class);
		
	}
	
	
}

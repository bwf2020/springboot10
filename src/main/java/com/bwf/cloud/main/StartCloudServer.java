package com.bwf.cloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages="com.bwf.cloud.controller")
@EnableFeignClients(basePackages="com.bwf.cloud.client")
public class StartCloudServer {

	public static void main(String[] args) {


		System.out.println("����cloud����");
		SpringApplication.run(StartCloudServer.class);
		System.out.println("cloud����ɹ�����");
	}

}

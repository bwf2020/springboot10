package com.bwf.config;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.bwf.entity.User;

@Configuration
public class MyConfig {

	@Value("${name}")
	private String name;
	
	@Value("#{'${list}'.split(',')}")
	private List list;
	
	@Value("#{${map}}")
	private Map map;
	
	@Value("${list}")
	private String[] str;
	
	
	
	public MyConfig() {
		
		
		System.out.println("配置对象实例化......................");
	
		
		
	}
	
	@Bean
	public User getUser() {
		
		System.out.println(name);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(map);
		System.out.println(map.get("a"));
		
		System.out.println(str);
		System.out.println(str.length);
		
		return new User();
	}
	

	
}

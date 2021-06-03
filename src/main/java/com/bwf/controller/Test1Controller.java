package com.bwf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bwf.entity.User;

@Controller
public class Test1Controller {
	

	@Autowired
	private User user;
	
	@RequestMapping("test1")
	@ResponseBody
	public String test1() {
		
		System.out.println("请求了test1....................");
		System.out.println(user);
		return "hello springboot ";
	}
	
	
	@RequestMapping("test2")
	public String test2() {
		
		System.out.println("请求了test2....................");

		return "forward:index.jsp";
	}
	
	@RequestMapping("test3")
	public ModelAndView test3() {
		
		System.out.println("请求了test3....................");

		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("name", "博为峰");
		System.out.println(1/0);
		
		
		return mv;
	}
	

}

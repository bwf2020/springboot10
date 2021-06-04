package com.bwf.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bwf.entity.User;
import com.bwf.service.IUserService;

@Controller
public class Test1Controller {
	

	@Autowired
	private User user;
	
	@Resource
	private IUserService userService;
	
	@Autowired
	private StringRedisTemplate srt;
	
	@Resource
	private RedisTemplate<Object, Object> rt;
	
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
	
	
	@RequestMapping("reg.do")
	public ModelAndView reg(User user) {
		
		System.out.println("请求了注册功能....................");

		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("name", "注册成功");

		userService.reg(user);
		
		return mv;
	}
	
	
	
	@RequestMapping("test4")
	public ModelAndView test4() {
		
		System.out.println("请求了test4....................");

		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("name", "整合redis");

		
		System.out.println(srt);
		
		Set keys= srt.keys("*");
		System.out.println(keys.size());
		
		srt.boundValueOps("b").set("B");
		
		String a=srt.boundValueOps("a").get();
		
		System.out.println("a的值:"+a);
		
		srt.opsForValue().set("c", "C");
		
		
		/*User user=new User();
		user.setId(1);
		user.setName("张三");
		
		rt.opsForValue().set("user1", user);
		*/
		
		
		User user=(User) rt.opsForValue().get("user1");
		System.out.println(user.getName());
		
		return mv;
	}
	
	
	
	@RequestMapping("test5")
	public ModelAndView test5() {
		
		long times=0;
		
		String url="jdbc:mysql://localhost:3306/java10";
		String user="root";
		String password="123456";
		
		Connection conn;
		List<Object> userList=new ArrayList<Object>();
		
		
		
		
		
		//去连接redis
		long counts= rt.opsForList().size("userList");
		
		long start=System.currentTimeMillis();
		
		if(counts==0) {
			
		
		try {
			
			conn = DriverManager.getConnection(url, user, password);
			Statement cmd=conn.createStatement();
			ResultSet rs= cmd.executeQuery("select * from user");
			while(rs.next()) {
				
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				
				userList.add(u);
				
				//把集合数据存入redis
				rt.boundListOps("userList").leftPush(u);
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}else {
			
			userList= rt.boundListOps("userList").range(0, -1);
			
			
		}
		
		
		long end=System.currentTimeMillis();
		
		times=end-start;
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		mv.addObject("name", "耗时："+times);
		mv.addObject("userList", userList);
		
		
		return mv;
		
	}

}

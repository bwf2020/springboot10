package com.bwf.cloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.cloud.client.UserClient;
import com.bwf.entity.User;

@Controller
public class Test1Action {

	@Autowired
	private UserClient userClient;
	
	@RequestMapping("test1")
	public String test1() {
		
		 
		//远程调用服务提供的数据restful
		//http://localhost/user/show1
		userClient.show1();
		
		return "index";
		
	}
	
	
	@RequestMapping("test2")
	public String test2() {
		

		String str=userClient.show2();
		System.out.println("来自服务端的数据:"+str);
		
		return "index";
		
	}
	
	
	@RequestMapping("test3")
	public String test3() {
		

		List list=userClient.show3();
		System.out.println("来自服务端的数据:"+list);
		System.out.println(list.size());
		
		return "index";
		
	}
	
	@RequestMapping("test4")
	public String test4() {
		

		Map map=userClient.show4();
		System.out.println("来自服务端的数据:"+map);
		System.out.println(map.keySet().size());
		
		return "index";
		
	}

	
	@RequestMapping("test5")
	public String test5() {
		

		User user=userClient.show5();
		System.out.println("来自服务端的数据:"+user);
		System.out.println(user.getName());
		
		return "index";
		
	}
	
	
	@RequestMapping("test6")
	public String test6(int num) {
		

		int a=userClient.show6(num);
		System.out.println("来自服务端的数据:"+a);
	
		
		return "index";
		
	}
	
	@RequestMapping("test7")
	public String test7(Integer num) {
		

		int a=userClient.show7(num);
		System.out.println("来自服务端的数据:"+a);
	
		
		return "index";
		
	}
	
	@RequestMapping("test8")
	public String test8(String str) {
		

		String str2=userClient.show8(str);
		System.out.println("来自服务端的数据:"+str2);
	
		
		return "index";
		
	}
	
	
	@RequestMapping("test9")
	public String test9() {
		

		String[] strs= {"zhangsan","lisi","wangwu"};
		
		String str2=userClient.show9(strs);
		System.out.println("来自服务端的数据:"+str2);
	
		
		return "index";
		
	}
	
	
	@RequestMapping("test10")
	public String test10() {
		

		List list=new ArrayList();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		String str2=userClient.show10(list);
		System.out.println("来自服务端的数据:"+str2);
	
		
		return "index";
		
	}
	
	
	@RequestMapping("test11")
	public String test11() {
		

		Map map=new HashMap();
		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");
		
		String str2=userClient.show11(map);
		System.out.println("来自服务端的数据:"+str2);
	
		
		return "index";
		
	}
	
	@RequestMapping("test12")
	public String test12() {
		

		User user=new User();
		user.setId(1);
		user.setName("bwf");
		
		String str2=userClient.show12(user);
		System.out.println("来自服务端的数据:"+str2);
	
		
		return "index";
		
	}
	
}

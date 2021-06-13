package com.bwf.cloud.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bwf.entity.User;

@FeignClient(name="feign",url="http://localhost:8090/user")
public interface UserClient {

	@RequestMapping("show1")
	public void show1();
	
	@RequestMapping("show2")
	public String show2();
	
	
	@RequestMapping("show3")
	public List show3();
	
	
	@RequestMapping("show4")
	public Map show4();
	
	@RequestMapping("show5")
	public User show5();
	
	@RequestMapping("show6")
	public int show6(@RequestParam(name="num",required=false) int num);
	
	
	@RequestMapping("show7")
	public int show7(@RequestParam("num") Integer num);
	
	@RequestMapping("show8")
	public String show8(@RequestParam("str") String str);
	
	@RequestMapping("show9")
	public String show9(@RequestParam("strs") String[] strs);
	
	@RequestMapping("show10")
	public String show10(@RequestParam("list") List<String> list);
	
	@RequestMapping("show11")
	public String show11(@RequestParam("map") Map map);
	
	
	@RequestMapping("show12")
	public String show12(@RequestBody User user);
	
	
	
	
}

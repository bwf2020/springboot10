package com.bwf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwf.entity.User;
import com.bwf.mapper.UserMapper;

@Service
public class UserService implements IUserService{

	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	@Transactional
	public void reg(User user) {


		System.out.println("调用业务层注册...............");
		System.out.println(userMapper);
		
		userMapper.save(user);
		
		
	}

}

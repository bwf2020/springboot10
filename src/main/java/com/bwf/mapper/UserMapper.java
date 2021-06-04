package com.bwf.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bwf.entity.User;

@Mapper
public interface UserMapper {

	
	//@Insert("insert into user(id,name) values(#{id},#{name})")
	public void save(User user);
	
	
}

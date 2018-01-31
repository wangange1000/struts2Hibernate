package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	User get(Integer id);
	Integer save(User user);
	
	List<User> findByName(String name);
}

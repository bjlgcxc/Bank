package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.dao.UserDao;
import com.ssm.pojo.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public void addUser(User user){
		userDao.insert(user);
	}
	
	public void deleteUser(int id){
		userDao.delete(id);
	}
	
	public void updateUser(User user){
		userDao.update(user);
	}
	
	public User getUserById(int id){
		return userDao.selectById(id);
	}
	
	public User getUserByID(String name,String IDNo){
		return userDao.selectByID(name,IDNo);
	}
	
}

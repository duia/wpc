package com.wpc.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpc.admin.dao.UserDao;
import com.wpc.admin.model.User;
import com.wpc.admin.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(id);
	}

}

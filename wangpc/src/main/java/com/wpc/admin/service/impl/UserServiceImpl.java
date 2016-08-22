package com.wpc.admin.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wpc.admin.dao.UserDao;
import com.wpc.admin.entity.User;
import com.wpc.admin.service.UserService;
import com.wpc.common.BaseServiceImpl;

/**
 * 操作相关
 */
@Service(UserService.BEAN_ID)
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource(name=UserDao.BEAN_ID)
	private UserDao userDao;


}

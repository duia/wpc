package com.wpc.admin.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wpc.admin.dao.UserRoleDao;
import com.wpc.admin.entity.UserRole;
import com.wpc.admin.service.UserRoleService;
import com.wpc.common.BaseServiceImpl;

/**
 * 操作相关
 * author wpc
 */
@Service(UserRoleService.BEAN_ID)
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, Integer> implements UserRoleService {

	Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

	@Resource(name=UserRoleDao.BEAN_ID)
	private UserRoleDao userRoleDao;


}

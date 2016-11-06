package com.wpc.admin.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wpc.admin.dao.AuthPermissionDao;
import com.wpc.admin.entity.AuthPermission;
import com.wpc.admin.service.AuthPermissionService;
import com.wpc.common.BaseServiceImpl;

/**
 * 操作相关
 * author wpc
 */
@Service(AuthPermissionService.BEAN_ID)
public class AuthPermissionServiceImpl extends BaseServiceImpl<AuthPermission, Integer> implements AuthPermissionService {

	Logger logger = LoggerFactory.getLogger(AuthPermissionServiceImpl.class);

	@Resource(name=AuthPermissionDao.BEAN_ID)
	private AuthPermissionDao authPermissionDao;
	
	@Override
	public void addDefaultPermission(String perType, int resourceId, int parentId) {
		AuthPermission per = null;
		for (int i = 0; i < AuthPermissionServiceImpl.OPERATION_COUNT; i++) {
			per = new AuthPermission();
			per.setPermissionName(OPERATION_NAMES[i]);
			per.setPermissionCode(OPERATION_CODES[i]);
			per.setPermissionType(perType);
			per.setResourceId(resourceId);
			per.setParentId(parentId);
			per.setUpdateTime(new Date());
			authPermissionDao.save(per);
		}
	}

}

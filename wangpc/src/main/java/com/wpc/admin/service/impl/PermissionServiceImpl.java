package com.wpc.admin.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wpc.admin.dao.PermissionDao;
import com.wpc.admin.entity.Permission;
import com.wpc.admin.service.PermissionService;
import com.wpc.common.BaseServiceImpl;

/**
 * 操作相关
 * author wpc
 */
@Service(PermissionService.BEAN_ID)
public class PermissionServiceImpl extends BaseServiceImpl<Permission, Integer> implements PermissionService {

	Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

	@Resource(name=PermissionDao.BEAN_ID)
	private PermissionDao permissionDao;


}

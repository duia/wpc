package com.wpc.admin.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wpc.admin.dao.RolePermissionDao;
import com.wpc.admin.entity.RolePermission;
import com.wpc.admin.service.RolePermissionService;
import com.wpc.common.BaseServiceImpl;

/**
 * 操作相关
 * author wpc
 */
@Service(RolePermissionService.BEAN_ID)
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermission, Integer> implements RolePermissionService {

	Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);

	@Resource(name=RolePermissionDao.BEAN_ID)
	private RolePermissionDao rolePermissionDao;


}

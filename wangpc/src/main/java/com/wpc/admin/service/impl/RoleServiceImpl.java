package com.wpc.admin.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wpc.admin.dao.RoleDao;
import com.wpc.admin.entity.Role;
import com.wpc.admin.service.RoleService;
import com.wpc.common.BaseServiceImpl;

/**
 * 操作相关
 * author wpc
 */
@Service(RoleService.BEAN_ID)
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> implements RoleService {

	Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Resource(name=RoleDao.BEAN_ID)
	private RoleDao roleDao;


}

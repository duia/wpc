package com.wpc.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wpc.admin.dao.AuthMenuDao;
import com.wpc.admin.entity.AuthMenu;
import com.wpc.admin.service.AuthMenuService;
import com.wpc.common.BaseServiceImpl;

/**
 * 操作相关
 * author wpc
 */
@Service(AuthMenuService.BEAN_ID)
public class AuthMenuServiceImpl extends BaseServiceImpl<AuthMenu, Integer> implements AuthMenuService {

	Logger logger = LoggerFactory.getLogger(AuthMenuServiceImpl.class);

	@Resource(name=AuthMenuDao.BEAN_ID)
	private AuthMenuDao authMenuDao;

	@Override
	public List<AuthMenu> getLeftMenu() {
		// TODO Auto-generated method stub
		return authMenuDao.getLeftMenu();
	}


}

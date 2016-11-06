package com.wpc.admin.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wpc.admin.dao.AuthElementDao;
import com.wpc.admin.entity.AuthElement;
import com.wpc.admin.entity.AuthMenu;
import com.wpc.admin.service.AuthElementService;
import com.wpc.admin.service.AuthPermissionService;
import com.wpc.common.BaseServiceImpl;

/**
 * 操作相关
 * author wpc
 */
@Service(AuthElementService.BEAN_ID)
public class AuthElementServiceImpl extends BaseServiceImpl<AuthElement, Integer> implements AuthElementService {

	Logger logger = LoggerFactory.getLogger(AuthElementServiceImpl.class);

	@Resource(name=AuthElementDao.BEAN_ID)
	private AuthElementDao authElementDao;
	
	@Resource(name=AuthPermissionService.BEAN_ID)
	private AuthPermissionService authPermissionService;

	@Override
	public void addDefaultElements(AuthMenu menu) {
		AuthElement element = null;
		for (int i = 0; i < AuthPermissionServiceImpl.OPERATION_COUNT; i++) {
			element = new AuthElement();
			element.setMenuId(menu.getId());
			element.setElementName(AuthPermissionService.OPERATION_NAMES[i]);
			element.setElementCode(AuthPermissionService.OPERATION_CODES[i]);
			element.setElementDesc(menu.getMenuName()+"_"+AuthPermissionService.OPERATION_CODES[i]);
			authElementDao.save(element);
			//给element添加四种默认权限
			authPermissionService.addDefaultPermission(AuthPermissionService.PER_TYPE_ELEMENT, element.getId(), menu.getId());
		}
	}
	
}

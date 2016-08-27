package com.wpc.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wpc.admin.dao.MenuDao;
import com.wpc.admin.entity.Menu;
import com.wpc.admin.service.MenuService;
import com.wpc.common.BaseServiceImpl;

/**
 * 操作相关
 * author wpc
 */
@Service(MenuService.BEAN_ID)
public class MenuServiceImpl extends BaseServiceImpl<Menu, Integer> implements MenuService {

	Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

	@Resource(name=MenuDao.BEAN_ID)
	private MenuDao menuDao;

	@Override
	public List<Menu> getLeftMenu() {
		// TODO Auto-generated method stub
		return menuDao.getLeftMenu();
	}


}

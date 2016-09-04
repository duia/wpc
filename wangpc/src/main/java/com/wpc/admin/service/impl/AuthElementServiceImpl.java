package com.wpc.admin.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wpc.admin.dao.AuthElementDao;
import com.wpc.admin.entity.AuthElement;
import com.wpc.admin.service.AuthElementService;
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


}

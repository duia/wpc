package com.wpc.admin.service;

import java.util.List;

import com.wpc.admin.entity.AuthPermission;
import com.wpc.common.BaseService;

/**
 * 操作相关
 * author wpc
 */
public interface AuthPermissionService extends BaseService<AuthPermission, Integer> {
	
	public final static String BEAN_ID="authPermissionService";
	
}

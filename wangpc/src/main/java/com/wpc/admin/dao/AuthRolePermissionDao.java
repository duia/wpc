package com.wpc.admin.dao;

import com.wpc.admin.entity.AuthRolePermission;
import com.wpc.common.BaseDao;
/**
 * 操作相关
 * author wpc
 */
public interface AuthRolePermissionDao extends BaseDao<AuthRolePermission, Integer> {
	
	public final static String BEAN_ID="authRolePermissionDao";
	
}

package com.wpc.admin.dao;

import com.wpc.admin.entity.RolePermission;
import com.wpc.common.BaseDao;
/**
 * 操作相关
 * author wpc
 */
public interface RolePermissionDao extends BaseDao<RolePermission, Integer> {
	
	public final static String BEAN_ID="rolePermissionDao";
	
}

package com.wpc.admin.dao;

import com.wpc.admin.entity.Permission;
import com.wpc.common.BaseDao;
/**
 * 操作相关
 * author wpc
 */
public interface PermissionDao extends BaseDao<Permission, Integer> {
	
	public final static String BEAN_ID="permissionDao";
	
}

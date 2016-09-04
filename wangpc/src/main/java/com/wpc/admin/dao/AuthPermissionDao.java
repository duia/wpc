package com.wpc.admin.dao;

import java.util.List;

import com.wpc.admin.entity.AuthPermission;
import com.wpc.common.BaseDao;
/**
 * 操作相关
 * author wpc
 */
public interface AuthPermissionDao extends BaseDao<AuthPermission, Integer> {
	
	public final static String BEAN_ID="authPermissionDao";
	
	public List<AuthPermission> queryPermissionByRoleId(int rid);
}

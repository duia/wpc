package com.wpc.admin.dao;

import com.wpc.admin.entity.UserRole;
import com.wpc.common.BaseDao;
/**
 * 操作相关
 * author wpc
 */
public interface UserRoleDao extends BaseDao<UserRole, Integer> {
	
	public final static String BEAN_ID="userRoleDao";
	
}
